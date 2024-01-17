package com.springboot.webservices.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.webservices.Dto.StudentDto;
import com.springboot.webservices.entity.Student;
import com.springboot.webservices.mapper.StudentMapper;
import com.springboot.webservices.repository.StudentRepository;
import com.springboot.webservices.service.StudentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    
    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        // Convert StudentDto into Student Jpa Entity
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);

        // Convert Student Jpa into Student Dto
        return StudentMapper.mapToStudentDto(savedStudent);
       
            
        
    }

    @Override
    public StudentDto getStudentById(Long Id) {
        Optional<Student> optionalStudent = studentRepository.findById(Id);

        Student student = optionalStudent.get();
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> student = studentRepository.findAll();
        return student.stream().map(StudentMapper::mapToStudentDto).
          collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(StudentDto student) {
         Student existingStudent = studentRepository.findById(student.getId()).get();
         existingStudent.setFirstName(student.getFirstName());
         existingStudent.setLastName(student.getLastName());
         existingStudent.setEmail(student.getEmail());
         Student updated = studentRepository.save(existingStudent);
         return StudentMapper.mapToStudentDto(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
         studentRepository.deleteById(id);
    }
    
}
