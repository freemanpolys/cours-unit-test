package com.example.springbootintegrationtest.controller;

import com.example.springbootintegrationtest.domain.Student;
import com.example.springbootintegrationtest.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.PostConstruct;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerMockMvcTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void testCreateStudent() throws Exception {
        Student student = new Student("Zaphod", "zaphod@galaxy.net");
        mockMvc.perform(post("/student")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", is("zaphod@galaxy.net")))
                .andExpect(jsonPath("$.name", is("Zaphod")));

        Student studentFromDb = studentRepository.findStudentByName("Zaphod");
        assertThat(studentFromDb).isNotNull();
        assertThat(studentFromDb.getDescription()).isEqualTo("zaphod@galaxy.net");

    }


    @Test
    public void testRetrieveStudent() throws Exception {
        mockMvc.perform(get("/students/{studentId}",5L)
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(5)))
                .andExpect(jsonPath("$.description", is("Student 5")))
                .andExpect(jsonPath("$.name", is("Ipsum")));

    }

}
