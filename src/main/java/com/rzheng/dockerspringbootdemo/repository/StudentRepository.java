package com.rzheng.dockerspringbootdemo.repository;

import com.rzheng.dockerspringbootdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
