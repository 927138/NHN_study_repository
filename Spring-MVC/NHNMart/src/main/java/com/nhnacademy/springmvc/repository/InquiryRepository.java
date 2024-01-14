package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Answer;
import com.nhnacademy.springmvc.domain.Category;
import com.nhnacademy.springmvc.domain.Inquiry;
import java.util.List;

public interface InquiryRepository {

     boolean exists(Long id);
     Inquiry getInquiryFindByKey(long id);
     Inquiry createInquiry(String title, String content, Category categorize, String date, String author, List<String> images);
     List<Inquiry> getInquiryFindByIdAll(String cusId);
     List<Inquiry> getInquiryFindByCategory(String cusId, Category category);
     List<Inquiry> getInquiryFindByNotAnswer();
     Inquiry modify(String id);
     void inquiryAnswerUpdate(long id, Answer answer);
}
