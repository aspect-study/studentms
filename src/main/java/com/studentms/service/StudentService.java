package com.studentms.service;

import com.studentms.exceptions.DatabaseException;
import com.studentms.exceptions.StudentNotFoundException;
import com.studentms.exceptions.ValidationException;
import com.studentms.model.Student;

import java.util.List;

public interface StudentService {

    void createStudent(Student student) throws DatabaseException, ValidationException;

    List<Student> getAllStudents() throws DatabaseException;

    Student getStudentById(Integer id) throws DatabaseException,
            StudentNotFoundException, ValidationException;

}
