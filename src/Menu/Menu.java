package Menu;

import Course.*;
import Decorators.*;
import Facade.*;
import java.sql.*;
import java.util.Scanner;
import Builder.*;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Connection conn;
    StudentPortalFacade portal = new StudentPortalFacade();

    public Menu() throws SQLException {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
    }

    public void start() throws SQLException {
        int choice;
        do {
            System.out.println("===== Learning Management System =====");
            System.out.println("1. registration (enroll in course)");
            System.out.println("2. start learning (enter grades)");
            System.out.println("3. complete course (certificate)");
            System.out.println("4. remove student");
            System.out.println("5. show all students");
            System.out.println("6. show leaderboard");
            System.out.println("0. end");
            System.out.print("choose: ");
            choice = getChoice();

            switch (choice) {
                case 1 -> registration();
                case 2 -> startLearning();
                case 3 -> completeCourse();
                case 4 -> removeStudent();
                case 5 -> showAllStudents();
                case 6 -> showLeaderboard();
                case 0 -> System.out.println("end");
                default -> System.out.println("error");
            }
        } while (choice != 0);
    }

    private void registration() throws SQLException {
        Course baseCourse = selectCourse();
        if (baseCourse == null) return;

        System.out.print("write name: ");
        String name = scanner.nextLine();

        System.out.print("add mentor? (y/n): ");
        boolean mentor = scanner.nextLine().equalsIgnoreCase("y");

        Integer mentorId = null;
        if (mentor) {
            mentorId = selectMentor(baseCourse.getClass().getSimpleName());
            if (mentorId == null) {
                System.out.println("No mentor found");
                mentor = false;
            } else {
                scanner.nextLine();
            }
        }

        System.out.print("add gamification? (y/n): ");
        boolean gam = scanner.nextLine().equalsIgnoreCase("y");

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


    private void startLearning() throws SQLException {
        System.out.print("enter student id: ");
        int id = getChoice();

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

            enterGrades(id, gam, ment);
        } else {
            System.out.println("student not found");
        }
    }

    private void completeCourse() throws SQLException {
        System.out.print("enter student id: ");
        int id = getChoice();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String name = rs.getString("name");
            String courseName = rs.getString("course");
            boolean gam = rs.getBoolean("gamification");
            boolean ment = rs.getBoolean("mentoradd");
            int total = rs.getInt("total_score");

            Course course = switch (courseName) {
                case "ProgrammingCourse" -> new ProgrammingCourse();
                case "MathCourse" -> new MathCourse();
                case "LanguageCourse" -> new LanguageCourse();
                default -> new ProgrammingCourse();
            };

            if (gam) course = new Gamification(course);
            if (ment) course = new MentorSupport(course);
            course = new Certificate(course);

            StringBuilder info = new StringBuilder();
            info.append("Certificate: ").append(name)
                    .append(" completed ").append(courseName)
                    .append(" with final score: ").append(total);
            if (ment && gam) info.append(" (+Mentor & Gamification)");
            else if (ment) info.append(" (+Mentor)");
            else if (gam) info.append(" (+Gamification)");

            System.out.println(info);
            portal.completeCourse(course);
        } else {
            System.out.println("student not found");
        }
    }

    private void removeStudent() throws SQLException {
        System.out.print("enter student id to remove: ");
        int id = getChoice();

        PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id = ?");
        ps.setInt(1, id);
        int rows = ps.executeUpdate();

        if (rows > 0) System.out.println("student removed");
        else System.out.println("student not found");
    }

    private void showAllStudents() throws SQLException {
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students ORDER BY id");
        System.out.println("ID | Name | Course | Mentor | Gamification | Total");
        System.out.println("-------------------------------------------------------");

        boolean found = false;
        while (rs.next()) {
            found = true;
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String course = rs.getString("course");
            boolean mentor = rs.getBoolean("mentoradd");
            boolean gam = rs.getBoolean("gamification");
            int total = rs.getInt("total_score");

            System.out.println(id + " | " + name + " | " + course + " | " + mentor + " | " + gam + " | " + total);
        }

        if (!found) System.out.println("no students found");
    }


    private Course selectCourse() {
        System.out.println("select course:");
        System.out.println("1. Programming");
        System.out.println("2. Math");
        System.out.println("3. Language");
        System.out.println("0. return");
        System.out.print("choose: ");
        int choice = getChoice();
        scanner.nextLine();

        return switch (choice) {
            case 1 -> new ProgrammingCourse();
            case 2 -> new MathCourse();
            case 3 -> new LanguageCourse();
            case 0 -> ;
            default -> null;
        };
    }

    private Integer selectMentor(String courseName) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM mentors WHERE course = ?");
        ps.setString(1, courseName);
        ResultSet rs = ps.executeQuery();

        System.out.println("Available mentors for " + courseName + ":");
        boolean hasMentors = false;
        while (rs.next()) {
            hasMentors = true;
            System.out.println(rs.getInt("id") + ". " + rs.getString("name"));
        }

        if (!hasMentors) return null;

        System.out.print("choose mentor id: ");
        int mentorId = getChoice();

        PreparedStatement check = conn.prepareStatement("SELECT COUNT(*) FROM mentors WHERE id = ?");
        check.setInt(1, mentorId);
        ResultSet checkRs = check.executeQuery();
        checkRs.next();
        if (checkRs.getInt(1) == 0) {
            return null;
        }

        return mentorId;
    }

    private void enterGrades(int studentId, boolean gam, boolean ment) throws SQLException {
        System.out.println("Enter monthly scores (0–100):");
        System.out.print("Month 1: ");
        int m1 = getChoice();
        System.out.print("Month 2: ");
        int m2 = getChoice();
        System.out.print("Month 3: ");
        int m3 = getChoice();

        int baseScore = m1 + m2 + m3;
        double multiplier = 1.0 + (gam ? 0.2 : 0) + (ment ? 0.1 : 0);
        int total = (int) Math.round(baseScore * multiplier);

        PreparedStatement ps = conn.prepareStatement(
                "UPDATE students SET month1=?, month2=?, month3=?, total_score=? WHERE id=?");
        ps.setInt(1, m1);
        ps.setInt(2, m2);
        ps.setInt(3, m3);
        ps.setInt(4, total);
        ps.setInt(5, studentId);
        ps.executeUpdate();

        System.out.println("Total score with bonuses: " + total);
    }

    private void showLeaderboard() throws SQLException {
        System.out.println("\n===== Leaderboard =====");
        String query = """
            SELECT s.name, s.course, s.total_score,
                   RANK() OVER (ORDER BY s.total_score DESC) AS rank
            FROM students s
            WHERE s.total_score > 0
            ORDER BY s.total_score DESC;
        """;

        ResultSet rs = conn.createStatement().executeQuery(query);

        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.println("Rank " + rs.getInt("rank") + ": " +
                    rs.getString("name") + " | " +
                    rs.getString("course") + " | Score: " +
                    rs.getInt("total_score"));
        }

        if (!found) System.out.println("No students have scores yet.");
    }

    private int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("enter number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
