package com.springboot.webservices.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.webservices.Dto.StudentDto;
import com.springboot.webservices.entity.Student;
import com.springboot.webservices.exception.ResourceNotFoundException;
import com.springboot.webservices.mapper.StudentMapper;
import com.springboot.webservices.repository.StudentRepository;
import com.springboot.webservices.service.StudentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    private ModelMapper modelMapper;
    
    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        // Convert StudentDto into Student Jpa Entity
        // Student student = StudentMapper.mapToStudent(studentDto);

        Student student = modelMapper.map(studentDto, Student.class);

        Student savedStudent = studentRepository.save(student);

        // Convert Student Jpa into Student Dto
         return modelMapper.map(savedStudent, StudentDto.class);
       
            
        
    }

    @Override
    public StudentDto getStudentById(Long Id) {
        Student student = studentRepository.findById(Id).orElseThrow(
            () -> new ResourceNotFoundException("Student", "id", Id)
        );
        // Student student = optionalStudent.get();
        // return StudentMapper.mapToStudentDto(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> student = studentRepository.findAll();
        // return student.stream().map(StudentMapper::mapToStudentDto).
        //   collect(Collectors.toList());

        return student.stream().map((Student) -> modelMapper.map(student, StudentDto.class)).
          collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(StudentDto student) {
         Student existingStudent = studentRepository.findById(student.getId()).orElseThrow(
            () -> new ResourceNotFoundException("Student", "id", student.getId())
         );
         existingStudent.setFirstName(student.getFirstName());
         existingStudent.setLastName(student.getLastName());
         existingStudent.setEmail(student.getEmail());
         Student updated = studentRepository.save(existingStudent);
        //  return StudentMapper.mapToStudentDto(existingStudent);
        return modelMapper.map(updated, StudentDto.class);
    }

    @Override
    public void deleteStudent(Long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Student", "id", id)
         );

         studentRepository.deleteById(id);
    }
    
}
