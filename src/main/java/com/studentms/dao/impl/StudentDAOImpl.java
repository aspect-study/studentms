package com.studentms.dao.impl;

import com.studentms.config.DatabaseConfig;
import com.studentms.dao.StudentDAO;
import com.studentms.exceptions.DatabaseException;
import com.studentms.exceptions.StudentNotFoundException;
import com.studentms.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private final DatabaseConfig databaseConfig;

    public StudentDAOImpl() {
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
            preparedStatement.setString(2, student.getEmail().trim());
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

    @Override
    public List<Student> findAll() throws DatabaseException {
        String sql = "SELECT * FROM students ORDER BY id";
        var students = new ArrayList<Student>();
        try (Connection connection = databaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("course"),
                        resultSet.getInt("age")
                ));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Failed to retrieve all students", e);
        }
        return students;
    }

    @Override
    public Student getStudentById(Integer id) throws DatabaseException, StudentNotFoundException{
        String sql = "Select * FROM students where id = ?";
        try (Connection connection = databaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setEmail(resultSet.getString("email"));
                    student.setCourse(resultSet.getString("course"));
                    student.setAge(resultSet.getInt("age"));
                    return student;
                } else {
                    throw new StudentNotFoundException("Student not found with ID " + id);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Failed to find student by ID", e);
        }
    }
}
