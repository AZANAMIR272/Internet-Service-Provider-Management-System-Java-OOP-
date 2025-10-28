package app.db;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    // private static final String URL =
    // "jdbc:mysql://localhost:3306/isp_db?useSSL=false&serverTimezone=UTC";
    // private static final String USER = "root";
    // private static final String PASS = "your_password";

    public static Connection getConnection() throws SQLException {
        // No-op for in-memory implementation
        return null;
    }
}
