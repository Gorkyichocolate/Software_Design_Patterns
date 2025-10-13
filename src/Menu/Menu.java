package Menu;

import Course.*;
import Decorators.*;
import Facade.*;
import java.sql.*;
import java.util.Scanner;

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
            System.out.println("1. registration (enroll in course)");
            System.out.println("2. start learning");
            System.out.println("3. complete");
            System.out.println("4. remove student");
            System.out.println("5. show all students");
            System.out.println("0. end");
            System.out.print("choose: ");
            choice = getChoice();

            switch (choice) {
                case 1 -> registration();
                case 2 -> startLearning();
                case 3 -> completeCourse();
                case 4 -> removeStudent();
                case 5 -> showAllStudents();
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

        System.out.print("add gamification? (y/n): ");
        boolean gam = scanner.nextLine().equalsIgnoreCase("y");

        String baseName = baseCourse.getClass().getSimpleName();

        Course course = baseCourse;
        if (mentor) course = new MentorSupport(course);
        if (gam) course = new Gamification(course);

        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO students (name, course, gamification, mentoradd) VALUES (?, ?, ?, ?)");
        ps.setString(1, name);
        ps.setString(2, baseName);
        ps.setBoolean(3, gam);
        ps.setBoolean(4, mentor);
        ps.executeUpdate();

        portal.enrollInCourse(course);
        System.out.println("student " + name + " enrolled in " + baseName);
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
            info.append("Certificate: ").append(name).append(" completed ").append(courseName);
            if (ment && gam) info.append(" with Mentor and Gamification");
            else if (ment) info.append(" with Mentor");
            else if (gam) info.append(" with Gamification");

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

        if (rows > 0) {
            System.out.println("student removed");
        } else {
            System.out.println("student not found");
        }
    }

    private void showAllStudents() throws SQLException {
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students ORDER BY id");
        System.out.println("ID | Name | Course | Mentor | Gamification");
        System.out.println("-------------------------------------------");

        boolean found = false;
        while (rs.next()) {
            found = true;
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String course = rs.getString("course");
            boolean mentor = rs.getBoolean("mentoradd");
            boolean gam = rs.getBoolean("gamification");

            System.out.println(id + " | " + name + " | " + course + " | " + mentor + " | " + gam);
        }

        if (!found) {
            System.out.println("no students found");
        }
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
            case 0 -> null;
            default -> null;
        };
    }

    private int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("enter number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
