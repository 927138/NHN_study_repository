//package com.nhnacademy.edu.springframework.project.repository;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class StudentsTest {
//
//    private static Students students = CsvStudents.getInstance();
//    @AfterEach
//    void listClear(){
//        students.findAll().clear();
//    }
//
//    @Test
//    void load() {
//
//        students.load();
//
//        Assertions.assertNotNull(students);
//        Assertions.assertEquals(4, students.findAll().size());
//    }
//
//    @Test
//    void findAll() {
//
//        students.load();
//
//        Assertions.assertNotNull(students.findAll());
//        Assertions.assertEquals(4, students.findAll().size());
//    }
//
//    @Test
//    void merge() {
//        Scores scores = CsvScores.getInstance();
//        students.load();
//        scores.load();
//
//        students.merge(scores.findAll());
//
//        Assertions.assertNotNull(students.findAll());
//        Assertions.assertNotNull(scores.findAll());
//
//        long nullCount = students.findAll().stream().filter(student -> student.getScore() == null).count();
//        Assertions.assertEquals(1, nullCount);
//    }
//}