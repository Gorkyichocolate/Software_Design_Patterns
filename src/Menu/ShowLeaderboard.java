package Menu;

import java.sql.*;

public class ShowLeaderboard {
    Connection conn;

    public ShowLeaderboard() throws SQLException {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
    }

    public void showLeaderboard() throws SQLException {
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
}
