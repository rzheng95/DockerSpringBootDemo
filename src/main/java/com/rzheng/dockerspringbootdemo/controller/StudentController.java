package com.rzheng.dockerspringbootdemo.controller;

import com.rzheng.dockerspringbootdemo.entity.Student;
import com.rzheng.dockerspringbootdemo.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepo;

    public StudentController(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping("/students")
    public List<Student> listAll() {
        return studentRepo.findAll();
    }
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World! Richard!!!";
    }
}
