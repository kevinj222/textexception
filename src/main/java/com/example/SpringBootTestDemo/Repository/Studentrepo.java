package com.example.SpringBootTestDemo.Repository;

import com.example.SpringBootTestDemo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Studentrepo extends JpaRepository<Student,Integer>
{
    List<Student> findByName(String name);
}
