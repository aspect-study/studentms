package com.studentms.model.dto;

public class StudentDTO {

    private Integer id;
    private String name;
    private String email;
    private String course;
    private Integer age;

    public StudentDTO() {}

    public StudentDTO(String name, String email, String course, Integer age) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.age = age;
    }

    public StudentDTO(Integer id, String name, String email, String course, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', email='%s', course='%s', age=%d}",
                id, name, email, course, age);
    }
}
