package com.example.springbootintegrationtest.controller;

import com.example.springbootintegrationtest.domain.Student;
import com.example.springbootintegrationtest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    
    @PostMapping("/students")
    public ResponseEntity<Void> createStudent() {
        List<Student>students  =  studentService.createStudent();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(students.get(0).getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping("/students/{studentId}")
    public Student retrieveStudent(@PathVariable Integer studentId) {
        return studentService.retrieveStudent(studentId);
    }
}
