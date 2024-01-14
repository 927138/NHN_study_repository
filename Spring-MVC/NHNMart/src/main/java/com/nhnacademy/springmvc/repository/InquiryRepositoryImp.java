package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Answer;
import com.nhnacademy.springmvc.domain.Category;
import com.nhnacademy.springmvc.domain.Inquiry;
import com.nhnacademy.springmvc.exception.InquiryNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InquiryRepositoryImp implements InquiryRepository{

     private final Map<Long, Inquiry> inquiryRepository = new HashMap<>();

     @Override
     public boolean exists(Long id) {
          return inquiryRepository.containsKey(id);
     }

     @Override
     public Inquiry getInquiryFindByKey(long id) {
          if(!exists(id))
               throw new InquiryNotFoundException();
          return inquiryRepository.get(id);
     }

     @Override
     public Inquiry createInquiry(String title, String content, Category categorize, String date, String author, List<String> images) {
          long id = inquiryRepository.keySet()
                  .stream()
                  .max(Comparator.comparing(Function.identity()))
                  .map(cnt -> cnt+1)
                  .orElse(1L);

          Inquiry inquiry = Inquiry.createInquiry(id, title, content, categorize, date, author, images);
          inquiryRepository.put(id, inquiry);

          return inquiry;
     }

     @Override
     public List<Inquiry> getInquiryFindByIdAll(String cusId) {
          return inquiryRepository.keySet().stream()
                  .filter(index -> inquiryRepository.get(index).getAuthor().equals(cusId))
                  .map(index -> inquiryRepository.get(index))
                  .sorted(Comparator.comparingLong(Inquiry::getId).reversed())
                  .collect(Collectors.toList());
     }

     @Override
     public List<Inquiry> getInquiryFindByCategory(String cusId, Category category) {
          List<Inquiry> byIdList = getInquiryFindByIdAll(cusId);
          return byIdList.stream()
                  .filter(inquiry -> category == inquiry.getCategorize())
                  .collect(Collectors.toList());
     }

     @Override
     public List<Inquiry> getInquiryFindByNotAnswer() {
          return inquiryRepository.keySet().stream()
                  .filter(index -> !inquiryRepository.get(index).isAnswerCheck())
                  .map(index -> inquiryRepository.get(index))
                  .collect(Collectors.toList());
     }

     @Override
     public Inquiry modify(String id) {
          return null;
     }

     @Override
     public void inquiryAnswerUpdate(long id, Answer answer) {

          Inquiry storageInquiry = getInquiryFindByKey(id);
          storageInquiry.setAnswerCheck(true);
          storageInquiry.setAnswer(answer);
     }
}
