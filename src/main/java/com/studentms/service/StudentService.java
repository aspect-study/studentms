package com.studentms.service;

import com.studentms.exceptions.DatabaseException;
import com.studentms.model.Student;

public interface StudentService {

    void createStudent(Student student) throws DatabaseException;

}
