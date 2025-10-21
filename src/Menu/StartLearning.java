package Menu;

import Course.*;
import Decorators.*;
import Facade.*;
import java.sql.*;

public class StartLearning {
    Connection conn;
    StudentPortalFacade portal = new StudentPortalFacade();
    EnterGrades enterGrades = new EnterGrades();

    public StartLearning() throws SQLException {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
    }

    public void startLearning() throws SQLException {
        System.out.print("enter student id (0 to return): ");
        int id = GetChoice.getChoice();
        if (id == 0) return;

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String name = rs.getString("name");
            String courseName = rs.getString("course");
            boolean gam = rs.getBoolean("gamification");
            boolean ment = rs.getBoolean("mentoradd");

            Course course = switch (courseName) {
                case "ProgrammingCourse" -> new ProgrammingCourse();
                case "MathCourse" -> new MathCourse();
                case "LanguageCourse" -> new LanguageCourse();
                default -> new ProgrammingCourse();
            };

            if (gam) course = new Gamification(course);
            if (ment) course = new MentorSupport(course);

            System.out.println(name + " is starting learning " + courseName + ":");
            portal.startLearning(course);

            enterGrades.enterGrades(id, gam, ment);
        } else {
            System.out.println("student not found");
        }
    }
}
