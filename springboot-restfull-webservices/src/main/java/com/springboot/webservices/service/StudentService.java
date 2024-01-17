package com.springboot.webservices.service;

import java.util.List;

import com.springboot.webservices.entity.Student;

public interface StudentService {

    Student createStudent(Student student);

    Student getStudentById(Long Id);

    List<Student> getAllStudent();

    Student updateStudent(Student student);

    void deleteStudent(Long id);
    
}
