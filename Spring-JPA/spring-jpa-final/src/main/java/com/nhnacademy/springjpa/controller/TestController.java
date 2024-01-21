package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.entity.HouseHold;
import com.nhnacademy.springjpa.entity.HouseholdCompositionResident;
import com.nhnacademy.springjpa.entity.HouseholdMovementAddress;
import com.nhnacademy.springjpa.repository.BirthDeathReportResidentRepository;
import com.nhnacademy.springjpa.repository.CertificateIssueRepository;
import com.nhnacademy.springjpa.repository.FamilyRelationShipRepository;
import com.nhnacademy.springjpa.repository.HouseHoldRepository;
import com.nhnacademy.springjpa.repository.HouseholdCompositionResidentRepository;
import com.nhnacademy.springjpa.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.springjpa.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TestController {

     private final ResidentRepository residentRepository;
     private final FamilyRelationShipRepository familyRelationShipRepository;
     private final CertificateIssueRepository certificateIssueRepository;
     private final BirthDeathReportResidentRepository birthDeathReportResidentRepository;
     private final HouseholdCompositionResidentRepository householdCompositionResident;
     private final HouseHoldRepository houseHoldRepository;
     private final HouseholdMovementAddressRepository householdMovementAddressRepository;



     @GetMapping("/")
     public String test(Model model){


          model.addAttribute("list", residentRepository.findAll());
          model.addAttribute("list2", familyRelationShipRepository.findAll());

          return "home";
     }
}
