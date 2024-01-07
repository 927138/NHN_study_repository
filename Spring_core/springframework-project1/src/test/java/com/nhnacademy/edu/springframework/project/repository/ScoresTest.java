//package com.nhnacademy.edu.springframework.project.repository;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ScoresTest {
//
//    private static final Scores scores = CsvScores.getInstance();
//
//    @AfterEach
//    void scoreListClear(){
//        scores.findAll().clear();
//    }
//
//    @Test
//    void load() {
//
//        //given
//
//        //when
//        scores.load();
//
//        //then
//        Assertions.assertNotNull(scores);
//        Assertions.assertEquals(3, scores.findAll().size());
//    }
//
//    @Test
//    void findAll() {
//        //given
//
//        //when
//        scores.load();
//
//        //then
//        Assertions.assertNotNull(scores);
//        Assertions.assertEquals(3, scores.findAll().size());
//    }
//}