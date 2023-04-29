package com.example.SpringBootTestDemo.Controller;

import com.example.SpringBootTestDemo.Entity.Student;
import com.example.SpringBootTestDemo.Service.StudentService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
//import java.util.logging.Logger;

@RestController
@RequestMapping("/student")
public class StudentController
{
    private final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService serv;
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student)
    {
        LOGGER.info("InsideStudentController addstudent method,RequestBody:{}",student);
        return serv.addStudent(student);
    }
    @GetMapping
    public List<Student> getAllStudent()
    {
        return serv.getAllStudent();
    }
    @GetMapping("/name/{student-id}")
    public Student getStudentById(@PathVariable("student-id")Integer id)
    {
        return serv.getStudentById(id);
    }
    @DeleteMapping("/{student-id}")
        public Student deleteStudentById(@PathVariable("student-id")Integer id) {
        return serv.deleteStudentById(id);
    }
    @GetMapping("/name/{student-name}")
    public List<Student>getStudentByName(@PathVariable("student-name")String name)
    {
        return serv.getStudentByName(name);
    }



}
