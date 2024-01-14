package com.nhnacademy.springmvc.contoller;

import com.nhnacademy.springmvc.domain.Inquiry;
import com.nhnacademy.springmvc.repository.InquiryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cs")
public class InquiryController {

     private final InquiryRepository inquiryRepository;

     @RequestMapping("/inquiry")
     public String getVIewInquiryList(@SessionAttribute(LoginController.LOGIN_SUCESSES) String cusId, Model model) {
          List<Inquiry> inquiries = inquiryRepository.getInquiryFindByIdAll(cusId);
          model.addAttribute("inquiryList", inquiries);

          return "inquiryView";
     }

     @GetMapping(value = "/inquiry/{inquiryId}")
     public String getViewInquiryDetails(@PathVariable("inquiryId") long inquiryId, Model model) {
          model.addAttribute("inquiryDetail", inquiryRepository.getInquiryFindByKey(inquiryId));
          return "inquiryDetails";
     }

}
