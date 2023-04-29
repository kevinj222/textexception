package com.example.SpringBootTestDemo.StudentControllerTest;

import com.example.SpringBootTestDemo.Controller.StudentController;
import com.example.SpringBootTestDemo.Entity.Student;
import com.example.SpringBootTestDemo.Service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(StudentController.class)
public class StudentTestController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentServices;
    private Student student;
    @BeforeEach
    void setup() {
        student = new Student(1, "migha", "kerala", "2456");
    }
    @Test
    void testSaveStudent() throws Exception {
        Student student = new Student(1,"migha","kerala","245137");
        Mockito.when(studentServices.addStudent(student)).thenReturn(student);
        mockMvc.perform(MockMvcRequestBuilders.post("/student/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\r\n" +
                                " \"id\" : 1, \r\n" +
                                " \"name\" : \"migha\", \r\n" +
                                " \"address\" :\"kerala\", \r\n" +
                                " \"rollNo\" : \"245137\" \r\n" + "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}