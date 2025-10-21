package Menu;

import java.sql.*;

public class SelectMentor {
    Connection conn;

    public SelectMentor() throws SQLException {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
    }

    public Integer selectMentor(String courseName) throws SQLException {
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

        System.out.print("choose mentor id (0 to cancel): ");
        int mentorId = GetChoice.getChoice();
        if (mentorId == 0) return null;

        PreparedStatement check = conn.prepareStatement("SELECT COUNT(*) FROM mentors WHERE id = ?");
        check.setInt(1, mentorId);
        ResultSet checkRs = check.executeQuery();
        checkRs.next();
        if (checkRs.getInt(1) == 0) {
            return null;
        }

        return mentorId;
    }
}
