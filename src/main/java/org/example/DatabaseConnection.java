package org.example;
import java.sql.*;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/employee_db";
        String username = "postgres";
        String password = "123";

        return DriverManager.getConnection(url, username, password);
    }
}
