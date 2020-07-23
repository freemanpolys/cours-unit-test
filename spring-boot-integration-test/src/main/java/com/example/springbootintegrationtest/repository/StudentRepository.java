package com.example.springbootintegrationtest.repository;

import com.example.springbootintegrationtest.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student findStudentByName(String name);
}
