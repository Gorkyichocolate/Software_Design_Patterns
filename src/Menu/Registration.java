package Menu;

import Course.*;
import Decorators.*;
import Facade.*;
import Builder.*;
import java.sql.*;

public class Registration {
    Connection conn;
    StudentPortalFacade portal = new StudentPortalFacade();
    SelectCourse selectCourse = new SelectCourse();
    SelectMentor selectMentor = new SelectMentor();

    public Registration() throws SQLException {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
    }

    public void registration() throws SQLException {
        Course baseCourse = selectCourse.selectCourse();
        if (baseCourse == null) return;

        System.out.print("write name: ");
        String name = GetChoice.getScanner().nextLine();

        System.out.print("add mentor? (y/n): ");
        boolean mentor = GetChoice.getScanner().nextLine().equalsIgnoreCase("y");

        Integer mentorId = null;
        if (mentor) {
            mentorId = selectMentor.selectMentor(baseCourse.getClass().getSimpleName());
            GetChoice.getScanner().nextLine();

            if (mentorId == null) {
                System.out.println("No mentor found");
                mentor = false;
            }
        }

        System.out.print("add gamification? (y/n): ");
        boolean gam = GetChoice.getScanner().nextLine().equalsIgnoreCase("y");

        String baseName = baseCourse.getClass().getSimpleName();
        Course course = baseCourse;
        if (mentor) course = new MentorSupport(course);
        if (gam) course = new Gamification(course);

        Student student = new StudentImpl()
                .setName(name)
                .setCourseName(baseName)
                .setMentor(mentor)
                .setGamification(gam)
                .build();

        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO students (name, course, gamification, mentoradd, mentor_id) VALUES (?, ?, ?, ?, ?)");
        ps.setString(1, name);
        ps.setString(2, baseName);
        ps.setBoolean(3, gam);
        ps.setBoolean(4, mentor);
        if (mentorId != null) ps.setInt(5, mentorId); else ps.setNull(5, Types.INTEGER);
        ps.executeUpdate();

        portal.enrollInCourse(course);

        System.out.println("Student " + name + " enrolled in " + baseName +
                (mentor ? " (with mentor)" : "") +
                (mentor && gam ? " and" : "") +
                (gam ? " (with gamification)" : ""));

        student.printStudent();
    }
}
