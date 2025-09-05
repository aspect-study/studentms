package com.studentms.dao;

import com.studentms.exceptions.DatabaseException;
import com.studentms.exceptions.StudentNotFoundException;
import com.studentms.model.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student) throws DatabaseException;
    List<Student> findAll() throws DatabaseException;
    Student getStudentById(Integer id) throws DatabaseException, StudentNotFoundException;
}
