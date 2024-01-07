package com.nhnacademy.edu.springframework.project.repository;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class CsvScores implements Scores {

    private final List<Score> scores = new LinkedList<>();
    private CsvScores(){}

    /** TODO 2 :
     * Java Singleton 패턴으로 getInstance() 를 구현하세요.
     **/
    private static class CsvSocresSingleton{
        private static final CsvScores scores = new CsvScores();
    }

    public static Scores getInstance() {
        return CsvSocresSingleton.scores;
    }

    // TODO 5 : score.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요.
    @Override
    public void load() {
        InputStream scoreRepositoryPath = getClass().getClassLoader().getResourceAsStream("data/score.csv");
        if(scoreRepositoryPath == null){
            throw new NullPointerException("score.csv file resource path is null");
        }

        try (BufferedReader loadScore = new BufferedReader(new InputStreamReader(scoreRepositoryPath))){
            String readLine;
            while ((readLine = loadScore.readLine()) != null){
                String[] splitLine = readLine.split(",");
                int studentSequence = Integer.parseInt(splitLine[0]);
                int studentScore = Integer.parseInt(splitLine[1]);

                scores.add(new Score(studentSequence, studentScore));
            }

        } catch (IOException e){
            e.getStackTrace();
        }
    }

    @Override
    public List<Score> findAll() {
        return scores;
    }
}
