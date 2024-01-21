package com.nhnacademy.springjpa.controller.rest;

import com.nhnacademy.springjpa.domain.ResidentRegisterRequest;
import com.nhnacademy.springjpa.domain.ResidentUpdateDeathRequest;
import com.nhnacademy.springjpa.entity.Resident;
import com.nhnacademy.springjpa.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ResidentController {

     private final ResidentService residentService;

     @PostMapping("/residents")
     @ResponseStatus(value = HttpStatus.CREATED)
     public Resident saveResident(@RequestBody ResidentRegisterRequest resident){
          return residentService.saveResident(resident);
     }

     @PutMapping("/residents/{serialNumber}")
     public Resident updateDeathResident(@PathVariable("serialNumber") Integer serialNumber,
             @RequestBody ResidentUpdateDeathRequest residentUpdateDeathRequest){
          return residentService.updateDeathResident(serialNumber, residentUpdateDeathRequest);
     }


}
