package Menu;

import java.sql.*;

public class RemoveStudents {
    Connection conn;

    public RemoveStudents() throws SQLException {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
    }

    public void removeStudent() throws SQLException {
        System.out.print("enter student id to remove (0 to return): ");
        int id = GetChoice.getChoice();
        if (id == 0) return;

        PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id = ?");
        ps.setInt(1, id);
        int rows = ps.executeUpdate();

        if (rows > 0) System.out.println("student removed");
        else System.out.println("student not found");
    }
}
