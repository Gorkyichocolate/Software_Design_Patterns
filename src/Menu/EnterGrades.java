package Menu;

import java.sql.*;

public class EnterGrades {
    Connection conn;

    public EnterGrades() throws SQLException {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
    }

    public void enterGrades(int studentId, boolean gam, boolean ment) throws SQLException {
        System.out.println("Enter monthly scores (0–100):");
        System.out.print("Month 1: ");
        int m1 = GetChoice.getChoice();
        System.out.print("Month 2: ");
        int m2 = GetChoice.getChoice();
        System.out.print("Month 3: ");
        int m3 = GetChoice.getChoice();

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
}
