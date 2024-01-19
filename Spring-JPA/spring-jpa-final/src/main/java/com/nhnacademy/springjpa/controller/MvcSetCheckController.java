package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.entity.Category;
import com.nhnacademy.springjpa.repository.CateogoryRepository;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcSetCheckController {

     private final CateogoryRepository cateogoryRepository;

     public MvcSetCheckController(CateogoryRepository cateogoryRepository) {
          this.cateogoryRepository = cateogoryRepository;
     }

     @GetMapping("/")
     public String getSettingCheckView(Model model){
          List<Category> list = cateogoryRepository.findAllBy();

          model.addAttribute("list", list);
          return "home";
     }
}
