package com.studentms;

import com.studentms.view.StudentManagementView;

/**
 * Main class of the Student Management Application Demo
 * @author Aspect;
 */
public class BasicStudentManagementCRUD {
    public static void main(String[] args) {

            StudentManagementView studentManagementView = new StudentManagementView();
            studentManagementView.displayMenu();
    }
}