package com.nhnacademy.springmvc.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Inquiry {
     private long id;
     private String title;
     private String content;
     private String author;
     private String date;
     private Category categorize;
     private List<String> images;
     @Setter
     private boolean answerCheck;
     @Setter
     private Answer answer;

     public static Inquiry createInquiry(long id, String title, String content, Category categorize, String date, String author, List<String> images){
          return new Inquiry(id, title, content, categorize, date, author, images);
     }

     private Inquiry(long id, String title, String content, Category categorize, String date, String author, List<String> images) {
          this.id=id;
          this.title = title;
          this.content = content;
          this.categorize = categorize;
          this.date = date;
          this.author = author;
          this.images = images;
          this.answerCheck = false;
          this.answer = null;
     }

}
