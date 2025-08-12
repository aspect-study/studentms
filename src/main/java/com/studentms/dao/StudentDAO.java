package com.studentms.dao;

import com.studentms.exceptions.DatabaseException;
import com.studentms.model.Student;

public interface StudentDAO {
    void save(Student student) throws DatabaseException;
}
