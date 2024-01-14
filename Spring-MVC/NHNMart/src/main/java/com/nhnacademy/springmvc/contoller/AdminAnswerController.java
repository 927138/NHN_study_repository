package com.nhnacademy.springmvc.contoller;

import com.nhnacademy.springmvc.domain.Answer;
import com.nhnacademy.springmvc.domain.AnswerRequest;
import com.nhnacademy.springmvc.domain.Inquiry;
import com.nhnacademy.springmvc.repository.InquiryRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cs")
public class AdminAnswerController {

     private final InquiryRepository inquiryRepository;

     @RequestMapping("/admin")
     public String getAdminNotAnswerList(Model model){
          List<Inquiry> inquiryList = inquiryRepository.getInquiryFindByNotAnswer();
          model.addAttribute("inquiryList", inquiryList);
          return "adminAnswerView";
     }

     @GetMapping("admin/image/{img}")
     public void getAdminImage(@PathVariable("img") String imagePath){
          System.out.println(imagePath);
     }


     @GetMapping("/admin/{inquiryId}")
     public String getAdminInquiryChoice(@PathVariable("inquiryId") long id, Model model){
          Inquiry inquiry = inquiryRepository.getInquiryFindByKey(id);
          model.addAttribute("inquiryDetail", inquiryRepository.getInquiryFindByKey(id));

          return "adminAnswerForm";
     }

     @PostMapping("/admin/{inquiryId}")
     public String postAdminAnswer(@Valid @ModelAttribute AnswerRequest answerRequest,
                                   @PathVariable("inquiryId") long id,
                                   @SessionAttribute(LoginController.LOGIN_SUCESSES) String cusId){

          SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String time = timeFormat.format(new Date(System.currentTimeMillis()));
          Answer answer =  new Answer(answerRequest.getContent(), time, cusId);
          inquiryRepository.inquiryAnswerUpdate(id, answer);

          return "redirect:/cs/admin";
     }
}
