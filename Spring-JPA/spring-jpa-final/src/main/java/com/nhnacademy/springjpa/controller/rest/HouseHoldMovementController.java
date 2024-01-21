package com.nhnacademy.springjpa.controller.rest;

import com.nhnacademy.springjpa.domain.HouseholdMovementAddressRequest;
import com.nhnacademy.springjpa.entity.HouseholdMovementAddress;
import com.nhnacademy.springjpa.service.HouseholdMovementAddressService;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class HouseHoldMovementController {

     private final HouseholdMovementAddressService householdMovementAddressService;

     @PostMapping("/household/{householdSerialNumber}/movement")
     public ResponseEntity<HouseholdMovementAddress> createHouseHoldMovement(
             @PathVariable("householdSerialNumber") Integer householdSerialNumber
             ){

          return ResponseEntity.ok(householdMovementAddressService.createHouseholdMovement(householdSerialNumber));
     }

     @PutMapping("/household/{householdSerialNumber}/movement/{reportDate}")
     public ResponseEntity<HouseholdMovementAddress> updateHouseHoldMovement(
             @PathVariable("householdSerialNumber")Integer householdSerialNumber,
             @PathVariable("reportDate") String reportDate,
             @RequestBody HouseholdMovementAddressRequest request
     ){
          return ResponseEntity.ok(householdMovementAddressService.updateHouseholdMovement(householdSerialNumber, reportDate, request));
     }

     @DeleteMapping("/household/{householdSerialNumber}/movement/{reportDate}")
     public ResponseEntity<HouseholdMovementAddress> deleteHouseHoldMovement(
             @PathVariable("householdSerialNumber")Integer householdSerialNumber,
             @PathVariable("reportDate")String reportDate
     ){
          householdMovementAddressService.deleteHouseholdMovement(householdSerialNumber, reportDate);
          return ResponseEntity.ok().build();
     }
}
