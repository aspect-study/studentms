package com.studentms.controller;

import com.studentms.exceptions.DatabaseException;
import com.studentms.model.Student;
import com.studentms.service.StudentService;
import com.studentms.service.impl.StudentServiceImpl;

public class StudentController {

    private final StudentService studentService;

    public StudentController() {
        this.studentService = new StudentServiceImpl();
    }

    public String createStudent(String name, String email, String course, Integer age) {
        try {
            Student student = new Student(name,email,course,age);
            studentService.createStudent(student);
            return "Student created successfully with ID: " + student.getId();
        }catch(DatabaseException e) {
            return "Database Error:" + e.getMessage();
        }
    }
}
