package com.example.springbootintegrationtest.controller;

import com.example.springbootintegrationtest.domain.Student;
import com.example.springbootintegrationtest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<Void> createStudent() {
        List<Student>students  =  studentService.generateStudent();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(students.get(0).getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/student")
    public ResponseEntity<Student> postStudent(@RequestBody Student student) {
        Student response = studentService.create(student);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/students/{studentId}")
    public Student retrieveStudent(@PathVariable Integer studentId) {
        return studentService.retrieveStudent(studentId);
    }
}
