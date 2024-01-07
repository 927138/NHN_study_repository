package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class CsvStudents implements Students {

    private final List<Student> studentList = new LinkedList<>();

    /** TODO 3 :
     * Java Singleton 패턴으로 getInstance() 를 구현하세요.
     **/
    private CsvStudents(){}
    private static class CsvStudentsSingleton{
        private static final CsvStudents students = new CsvStudents();
    }
    public static Students getInstance() {
        return CsvStudentsSingleton.students;
    }

    // TODO 7 : student.csv 파일에서 데이터를 읽어 클래스 멤버 변수에 추가하는 로직을 구현하세요.
    // 데이터를 적재하고 읽기 위해서, 적절한 자료구조를 사용하세요.
    @Override
    public void load() {
        InputStream scoreRepositoryPath = getClass().getClassLoader().getResourceAsStream("data/student.csv");
        if(scoreRepositoryPath == null){
            throw new NullPointerException("student.csv file resource path is null");
        }

        try (BufferedReader loadStudent= new BufferedReader(new InputStreamReader(scoreRepositoryPath))){
            String readLine;
            while ((readLine = loadStudent.readLine()) != null){
                String[] splitLine = readLine.split(",");
                int studentSequence = Integer.parseInt(splitLine[0]);
                String studentName =splitLine[1];

                studentList.add(new Student(studentSequence, studentName));
            }

        } catch (IOException e){
            e.getStackTrace();
        }
    }

    @Override
    public Collection<Student> findAll() {
        return studentList;
    }

    /**
     * TODO 8 : students 데이터에 score 정보를 추가하세요.
     * @param scores
     */
    @Override
    public void merge(Collection<Score> scores) {
        for(Student student : studentList) {
            for(Score score : scores) {
                if (student.getSeq() == score.getStudentSeq()) {
                    student.setScore(score);
                    break;
                }
            }
        }
    }
}
