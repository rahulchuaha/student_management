package com.springboot.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.webservices.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
