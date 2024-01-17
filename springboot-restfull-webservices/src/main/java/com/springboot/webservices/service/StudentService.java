package com.springboot.webservices.service;

import java.util.List;

import com.springboot.webservices.Dto.StudentDto;


public interface StudentService {

    StudentDto createStudent(StudentDto student);

    StudentDto getStudentById(Long Id);

    List<StudentDto> getAllStudent();

    StudentDto updateStudent(StudentDto student);

    void deleteStudent(Long id);
    
}
