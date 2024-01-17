package com.springboot.webservices.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.webservices.entity.Student;
import com.springboot.webservices.repository.StudentRepository;
import com.springboot.webservices.service.StudentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    
    @Override
    public Student createStudent(Student student) {
         return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long Id) {
        Optional<Student> optionalStudent = studentRepository.findById(Id);

        return optionalStudent.get();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
         Student existingStudent = studentRepository.findById(student.getId()).get();
         existingStudent.setFirstName(student.getFirstName());
         existingStudent.setLastName(student.getLastName());
         existingStudent.setEmail(student.getEmail());
         Student updated = studentRepository.save(existingStudent);
         return updated;
    }

    @Override
    public void deleteStudent(Long id) {
         studentRepository.deleteById(id);
    }
    
}
