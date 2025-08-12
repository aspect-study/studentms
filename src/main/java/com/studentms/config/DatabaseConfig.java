package com.studentms.config;

import com.studentms.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/student_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    private static DatabaseConfig instance;

    private DatabaseConfig() {}

    public static  DatabaseConfig getInstance() {
        if (instance == null) {
            synchronized (DatabaseConfig.class) {
                instance = new DatabaseConfig();
            }
        }
        return instance;
    }

    public Connection getConnection() throws DatabaseException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DATABASE_URL, DB_USERNAME, DB_PASSWORD);
        }catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException("Failed to establish database connection", e);
        }
    }

    public void testDBConnection() throws DatabaseException {
        try (Connection connection = getConnection()) {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Database connection successful!");
            }
        } catch (SQLException | DatabaseException e) {
            throw new DatabaseException("Database connection test failed!");
        }
    }
}
