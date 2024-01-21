package com.nhnacademy.springjpa.controller.rest;

import com.nhnacademy.springjpa.domain.BirthDeathDeleteRequest;
import com.nhnacademy.springjpa.domain.BirthDeathModifyRequest;
import com.nhnacademy.springjpa.domain.BirthDeathRegisterRequest;
import com.nhnacademy.springjpa.entity.BirthDeathReportResident;
import com.nhnacademy.springjpa.service.BirthDeathService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class BirthDeathController {

     private final BirthDeathService birthDeathService;

     @PostMapping("/residents/{serialNumber}/birth")
     public ResponseEntity<BirthDeathReportResident> createBirthResident(
             @PathVariable("serialNumber") Integer serialNumber,
             @RequestBody BirthDeathRegisterRequest request) {
          return ResponseEntity.ok(birthDeathService.birthDeathRegister(serialNumber, request));
     }

     @PutMapping("/residents/{serialNumber}/birth/{targetSerialNumber}")
     public ResponseEntity<BirthDeathReportResident> modifyBirthResident(
             @PathVariable("serialNumber") Integer serialNumber,
             @PathVariable("targetSerialNumber") Integer targetSerialNumber,
             @RequestBody BirthDeathModifyRequest modifyRequest){
          return ResponseEntity.ok(birthDeathService.birthDeathModify(serialNumber, targetSerialNumber, modifyRequest));
     }

     @DeleteMapping("/residents/{serialNumber}/birth/{targetSerialNumber}")
     public ResponseEntity<BirthDeathReportResident> deleteBirthResident(
             @PathVariable("serialNumber") Integer serialNumber,
             @PathVariable("targetSerialNumber") Integer targetSerialNumber,
             @RequestBody BirthDeathDeleteRequest deathDeleteRequest){

               birthDeathService.birthDelete(serialNumber, targetSerialNumber, deathDeleteRequest);
          return ResponseEntity.ok().build();
     }
}
