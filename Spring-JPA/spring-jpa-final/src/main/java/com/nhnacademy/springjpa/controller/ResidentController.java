package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.ResidentCertificateIssueDto;
import com.nhnacademy.springjpa.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ResidentController {

     private final ResidentService residentService;

     @GetMapping("/home")
     public String getHome(Model model,
                           @PageableDefault(size = 5) Pageable pageable){
          Page<ResidentCertificateIssueDto> residentPage = residentService.findByAllResidents(pageable);

          model.addAttribute("residentPages", residentPage);
          model.addAttribute("residentTotalPage", residentPage.getTotalPages());
          return "home";
     }
}
