package com.springboot.webservices.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webservices.entity.Student;
import com.springboot.webservices.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/student")
public class StudentController {
    
    private StudentService studentService;

    //build create rest api
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
         Student savStudent = studentService.createStudent(student);

         return new ResponseEntity<>(savStudent, HttpStatus.CREATED);
    }

    //build get by id rest api
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student student = studentService.getStudentById(id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // build get all student api
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> students = studentService.getAllStudent();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    //build update student rest api

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, 
                                                      @RequestBody Student student){

        student.setId(id);
        Student updatedStu =  studentService.updateStudent(student);

        return new ResponseEntity<>(updatedStu, HttpStatus.OK);
    }

    //building delete student rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }
}
