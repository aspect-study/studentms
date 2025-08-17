package com.studentms.validator;

import com.studentms.exceptions.ValidationException;
import com.studentms.model.Student;

import java.util.regex.Pattern;

public class StudentValidator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\s]{2,50}$");
    private static final Pattern COURSE_PATTERN = Pattern.compile("^[a-zA-Z\\s]{2,100}$");

    public static void validateStudent(Student student) throws ValidationException {
        validateName(student.getName());
        validateEmail(student.getEmail());
        validateCourse(student.getCourse());
        validateAge(student.getAge());
    }

    private static void validateAge(Integer age) throws ValidationException {
        if (age == null) {
            throw new ValidationException("age cannot be null");
        }
        if (age < 16 || age > 60) {
            throw new ValidationException("age must be between 16 and 60");
        }
    }

    private static void validateCourse(String course) throws ValidationException {
        if (course == null || course.trim().isEmpty()) {
            throw new ValidationException("course cannot be null or empty");
        }
        if (!COURSE_PATTERN.matcher(course.trim()).matches()) {
            throw new ValidationException("Course must contain only letters and spaces (2-100 characters)");
        }
    }

    private static void validateEmail(String email) throws ValidationException {
        if (email == null || email.trim().isEmpty()) {
            throw new ValidationException("email cannot be null or empty");
        }

        if (!EMAIL_PATTERN.matcher(email.trim()).matches()) {
            throw new ValidationException("Invalid email format");
        }
    }

    private static void validateName(String name) throws ValidationException {
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException("Name cannot be null or empty");
        }
        if (!NAME_PATTERN.matcher(name.trim()).matches()) {
            throw new ValidationException("Name must contain only letters and spaces (2-50 characters)");
        }
    }
}
