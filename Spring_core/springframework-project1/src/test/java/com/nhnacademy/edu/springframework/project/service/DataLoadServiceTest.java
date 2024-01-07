package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DataLoadServiceTest {

    @Test
    void loadAndMerge() {
        Scores scores = new CsvScores();
        Students students = new CsvStudents();
        CsvDataLoadService csvDataLoadService = new CsvDataLoadService(scores, students);

        csvDataLoadService.loadAndMerge();

        Assertions.assertEquals(4, students.findAll().size());
        Assertions.assertEquals(3, scores.findAll().size());
        Assertions.assertEquals(1, students.findAll().stream().filter(student -> student.getScore() == null).count());
    }
}