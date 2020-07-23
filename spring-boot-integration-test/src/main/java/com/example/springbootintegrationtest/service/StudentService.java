package com.example.springbootintegrationtest.service;

import com.example.springbootintegrationtest.domain.Student;
import com.example.springbootintegrationtest.repository.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> generateStudent() {
        List<Student> students = new ArrayList<Student>();
        List<Student> savedStudents = new ArrayList<Student>();
        students.add(new Student("Rajesh Bhojwani", "Class 10"));
        students.add(new Student("Sumit Sharma", "Class 9"));
        students.add(new Student("Rohit Chauhan", "Class 10"));
        Iterable<Student> itrStudents = repository.saveAll(students);
        itrStudents.forEach(savedStudents::add);
        return savedStudents;
    }
    public Student create(Student student) {
        return repository.save(student);
    }
    public Student retrieveStudent(Integer studentId) {
       return repository.findById(studentId).orElse(new Student());
    }
}
