package com.studentms.dao;

import com.studentms.exceptions.DatabaseException;
import com.studentms.model.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student) throws DatabaseException;
    List<Student> findAll() throws DatabaseException;
}
