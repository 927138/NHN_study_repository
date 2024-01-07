package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Student;
import com.nhnacademy.edu.springframework.project.repository.Students;
import java.util.Collection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentServiceTest {
     private static final Students students = new CsvStudents();
     private static final Scores scores = new CsvScores();
     private static final StudentService studentService = new DefaultStudentService(students);

     @BeforeEach
     void setup(){
          new CsvDataLoadService(scores, students).loadAndMerge();

          Score score = new Score(4, 20);
          for(Student student : students.findAll()){
               if(student.getScore() == null){
                    student.setScore(score);
               }
          }
     }

     @AfterEach
     void clear(){
          students.findAll().clear();
          scores.findAll().clear();
     }
     @Test
     void getPassedStudents() {

          Collection<Student> passedStudents = studentService.getPassedStudents();

          Assertions.assertEquals(2, passedStudents.size());
     }

     @Test
     void getStudentsOrderByScore() {

          Collection<Student> studentList = studentService.getStudentsOrderByScore();

          int min = Integer.MAX_VALUE;
          int max = Integer.MIN_VALUE;
          for(Student student : studentList){
               min = Math.min(min, student.getScore().getScore());
               max = Math.max(max, student.getScore().getScore());
          }

          Assertions.assertEquals(20, min);
          Assertions.assertEquals(80, max);

     }
}