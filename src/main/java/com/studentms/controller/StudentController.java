package com.studentms.controller;

import com.studentms.exceptions.DatabaseException;
import com.studentms.exceptions.StudentNotFoundException;
import com.studentms.exceptions.ValidationException;
import com.studentms.model.Student;
import com.studentms.service.StudentService;
import com.studentms.service.impl.StudentServiceImpl;

import java.util.List;

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
        } catch(DatabaseException e) {
            return "Database Error: " + e.getMessage();
        } catch (ValidationException e) {
            return "Validation Error: " + e.getMessage();
        }
    }

    public String getAllStudent() {
        var stringBuilder = new StringBuilder();
        try {
            List<Student> students = studentService.getAllStudents();
            if (students.isEmpty()) {
                return "No students found.";
            }
            for(Student student: students) {
                stringBuilder.append(student.toString()).append("\n");
            }
        } catch (DatabaseException e) {
            return "Database Error: " + e.getMessage();
        }
        return stringBuilder.toString();
    }

    public String getStudentById(Integer id) {
        try {
            Student student = studentService.getStudentById(id);
            return student.toString();
        } catch(DatabaseException e) {
            return "Database Error: " + e.getMessage();
        } catch (ValidationException e) {
            return "Validation Error: " + e.getMessage();
        } catch (StudentNotFoundException e) {
            return "Student Error: " + e.getMessage();
        }
    }
}
