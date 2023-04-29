package com.example.SpringBootTestDemo.Service;

import com.example.SpringBootTestDemo.Entity.Student;

import java.util.List;

public interface StudentService
{
    Student addStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentById(Integer id);

    Student deleteStudentById(Integer id);

    List<Student> getStudentByName(String name);


}
