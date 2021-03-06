package com.example.springbootintegrationtest.controller;

import com.example.springbootintegrationtest.domain.Student;
import com.example.springbootintegrationtest.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.PostConstruct;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {
    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Autowired
    StudentRepository repository;

    private String uri;
    @BeforeEach
    public void init() {
        uri = "http://localhost:" + port;
        // TODO: 24/07/2020 insert data with repository 
    }

    @AfterEach
    public void clean() {
        repository.deleteAll();
    }

    @Test
    public void testCreateStudent() throws Exception {
        String url = uri +  "/students";
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        assertThat(actual.contains("/students")).isTrue();
    }

    @Test
    public void testRetrieveStudent() throws Exception {
        String url = uri +  "/students/6";
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        String expected = "{\"id\":6,\"name\":\"Dolor\",\"description\":\"Student 6\"}";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testPostStudent() throws Exception {
        String url = uri +  "/student";
        Student student = new Student("Test1","Description1");

        HttpEntity<Student> entity = new HttpEntity<Student>(student, headers);
        ResponseEntity<Student> response = restTemplate.exchange(url, HttpMethod.POST, entity, Student.class);
        Student responseStudent = response.getBody();

        assertThat(responseStudent.getId()).isNotNull();
        assertThat(responseStudent.getName()).isEqualTo(student.getName());
        assertThat(responseStudent.getDescription()).isEqualTo(student.getDescription());
    }

}
