package com.studentms.service.impl;

import com.studentms.dao.StudentDAO;
import com.studentms.dao.impl.StudentDAOImpl;
import com.studentms.exceptions.DatabaseException;
import com.studentms.model.Student;
import com.studentms.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    public StudentServiceImpl() {
        this.studentDAO = new StudentDAOImpl();
    }

    @Override
    public void createStudent(Student student) throws DatabaseException {
        studentDAO.save(student);
    }
}
