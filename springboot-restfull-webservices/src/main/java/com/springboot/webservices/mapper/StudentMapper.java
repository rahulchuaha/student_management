package com.springboot.webservices.mapper;

import com.springboot.webservices.Dto.StudentDto;
import com.springboot.webservices.entity.Student;

public class StudentMapper {

    // map to student jpa to student dto entity
    public static StudentDto mapToStudentDto(Student student){

        return new StudentDto(student.getId(), student.getFirstName(),
                                                student.getLastName(), student.getEmail());
    }

    // map to student dto to student jpa entity
    public static Student mapToStudent(StudentDto studentDto){
        return new Student(studentDto.getId(), studentDto.getFirstName(),
                                       studentDto.getLastName(), studentDto.getEmail());
    }
    
}
