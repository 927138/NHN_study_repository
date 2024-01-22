package com.nhnacademy.edu.springboot.practice.repository;

import com.nhnacademy.edu.springboot.practice.entity.Student;
import com.nhnacademy.edu.springboot.practice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
