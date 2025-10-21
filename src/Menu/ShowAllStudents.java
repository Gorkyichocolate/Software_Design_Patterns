package Menu;

import java.sql.*;

public class ShowAllStudents {
    Connection conn;

    public ShowAllStudents() throws SQLException {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
    }

    public void showAllStudents() throws SQLException {
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
}
