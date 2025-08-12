package com.studentms;

import com.studentms.config.DatabaseConfig;
import com.studentms.dao.StudentDAO;
import com.studentms.dao.impl.StudentDAOImpl;
import com.studentms.exceptions.DatabaseException;
import com.studentms.model.Student;

/**
 * Main class of the Student Management Application Demo
 * @author Aspect;
 */
public class StudentManagementDemo {
    public static void main(String[] args) {
        System.out.println("Starting Student Management System...");
        try {
            //We need to call and test the database connection here
            //DatabaseConfig.getInstance().testDBConnection();

            Student student = new Student(
                    "Aspect",
                    "aspect@sample.com",
                    "BSSC",
                    60
            );


            DatabaseConfig databaseConfig = null;
            StudentDAO studentDAO = new StudentDAOImpl(databaseConfig);
            studentDAO.save(student);

        } catch (DatabaseException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
        }
        System.out.println("Stopped Student Management System...");
    }
}