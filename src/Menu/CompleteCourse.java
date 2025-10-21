package Menu;

import Course.*;
import Decorators.*;
import Facade.*;
import java.sql.*;

public class CompleteCourse {
    Connection conn;
    StudentPortalFacade portal = new StudentPortalFacade();

    public CompleteCourse() throws SQLException {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
    }

    public void completeCourse() throws SQLException {
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
}
