package com.nhnacademy.springjpa.controller.rest;

import com.nhnacademy.springjpa.domain.HouseHoldRequest;
import com.nhnacademy.springjpa.entity.HouseHold;
import com.nhnacademy.springjpa.service.HouseHoldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class HouseHoldController {

     private final HouseHoldService houseHoldService;

     @PostMapping("/household")
     public ResponseEntity<HouseHold> createHouseHold(@RequestBody HouseHoldRequest houseHoldRequest) {
          return ResponseEntity.ok(houseHoldService.registerHouseHold(houseHoldRequest));
     }

     @DeleteMapping("/household/{householdSerialNumber}")
     public ResponseEntity<HouseHold> deleteHouseHold(@PathVariable("householdSerialNumber") Integer serialNumber){
          houseHoldService.deleteHouseHold(serialNumber);
          return ResponseEntity.ok().build();
     }
}
