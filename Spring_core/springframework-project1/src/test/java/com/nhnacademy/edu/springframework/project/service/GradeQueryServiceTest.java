package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeQueryServiceTest {

     private static final Scores scores = new CsvScores();
     private static final Students studnet = new CsvStudents();
     private static final GradeQueryService queryService = new DefaultGradeQueryService(studnet, scores);

     @BeforeEach
     void setup(){
          new CsvDataLoadService(scores, studnet).loadAndMerge();
     }

     @AfterEach
     void clear(){
          studnet.findAll().clear();
          scores.findAll().clear();
     }
     @Test
     void getScoreByStudentName() {

          List<Score> ScoreList = queryService.getScoreByStudentName("A");
          Assertions.assertEquals(2, ScoreList.size());

          ScoreList = queryService.getScoreByStudentName("C");
          Assertions.assertEquals(0, ScoreList.size());
     }

     @Test
     void getScoreByStudentSeq() {

          Score resultScore = queryService.getScoreByStudentSeq(1);
          Assertions.assertEquals(1, resultScore.getStudentSeq());
          Assertions.assertEquals(30, resultScore.getScore());

          resultScore = queryService.getScoreByStudentSeq(4);
          Assertions.assertNull(resultScore);
     }
}