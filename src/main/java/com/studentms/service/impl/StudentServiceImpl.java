package com.studentms.service.impl;

import com.studentms.dao.StudentDAO;
import com.studentms.dao.impl.StudentDAOImpl;
import com.studentms.exceptions.DatabaseException;
import com.studentms.exceptions.StudentNotFoundException;
import com.studentms.exceptions.ValidationException;
import com.studentms.model.Student;
import com.studentms.service.StudentService;
import com.studentms.validator.StudentValidator;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    public StudentServiceImpl() {
        this.studentDAO = new StudentDAOImpl();
    }

    @Override
    public void createStudent(Student student) throws DatabaseException, ValidationException {
        StudentValidator.validateStudent(student);
        studentDAO.save(student);
    }

    @Override
    public List<Student> getAllStudents() throws DatabaseException {
        return studentDAO.findAll();
    }

    @Override
    public Student getStudentById(Integer id) throws DatabaseException,
            StudentNotFoundException, ValidationException {
        StudentValidator.validateStudentId(id);
        return studentDAO.getStudentById(id);
    }
}
