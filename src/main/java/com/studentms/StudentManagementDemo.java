package com.studentms;

import com.studentms.config.DatabaseConfig;
import com.studentms.dao.StudentDAO;
import com.studentms.dao.impl.StudentDAOImpl;
import com.studentms.exceptions.DatabaseException;
import com.studentms.model.Student;
import com.studentms.view.StudentManagementView;

/**
 * Main class of the Student Management Application Demo
 * @author Aspect;
 */
public class StudentManagementDemo {
    public static void main(String[] args) {

            StudentManagementView studentManagementView = new StudentManagementView();
            studentManagementView.displayMenu();
    }
}