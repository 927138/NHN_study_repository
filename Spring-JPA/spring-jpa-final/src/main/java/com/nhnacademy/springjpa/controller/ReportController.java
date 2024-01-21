package com.nhnacademy.springjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ReportController {
     @GetMapping("/report/{reportNumber}")
     public void getReport(@PathVariable("reportNumber") Long reportNumber){

     }
}
