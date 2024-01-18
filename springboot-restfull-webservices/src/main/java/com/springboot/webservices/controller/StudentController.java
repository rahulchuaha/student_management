package com.springboot.webservices.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.springboot.webservices.Dto.StudentDto;
import com.springboot.webservices.exception.ErrorDetails;
import com.springboot.webservices.exception.ResourceNotFoundException;
import com.springboot.webservices.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/student")
public class StudentController {
    
    private StudentService studentService;

    //build create rest api
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto student){
         StudentDto savStudent = studentService.createStudent(student);

         return new ResponseEntity<>(savStudent, HttpStatus.CREATED);
    }

    //build get by id rest api
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        StudentDto student = studentService.getStudentById(id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // build get all student api
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        List<StudentDto> students = studentService.getAllStudent();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    //build update student rest api

    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, 
                                                      @RequestBody StudentDto student){

        student.setId(id);
        StudentDto updatedStu =  studentService.updateStudent(student);

        return new ResponseEntity<>(updatedStu, HttpStatus.OK);
    }

    //building delete student rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                           WebRequest webRequest){
            
//             ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                errorCode : "STUDENT NOT FOUND"
//             );
//             return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);                                                                

//    }
}
