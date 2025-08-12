package com.studentms.dao.impl;

import com.studentms.config.DatabaseConfig;
import com.studentms.dao.StudentDAO;
import com.studentms.exceptions.DatabaseException;
import com.studentms.model.Student;

import java.sql.*;

public class StudentDAOImpl implements StudentDAO {

    private final DatabaseConfig databaseConfig;

    public StudentDAOImpl(DatabaseConfig databaseConfig) {
        this.databaseConfig = DatabaseConfig.getInstance();
    }

    @Override
    public void save(Student student) throws DatabaseException {
        String sql = "INSERT INTO students (name,email,course,age)" +
                " VALUES (?, ? , ?, ?)";
        try (Connection connection = databaseConfig.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement
                             (sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, student.getName().trim());
            preparedStatement.setString(2,student.getEmail().trim());
            preparedStatement.setString(3, student.getCourse().trim());
            preparedStatement.setInt(4, student.getAge());

            int affectRows = preparedStatement.executeUpdate();
            if (affectRows == 0) {
                throw new DatabaseException("Creating student failed, no rows affected.");
            }

            try (ResultSet generatedKey = preparedStatement.getGeneratedKeys()) {
                if (generatedKey.next()) {
                    student.setId(generatedKey.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Failed to save student", e);
        }
    }
}
