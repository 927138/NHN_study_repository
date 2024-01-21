package com.nhnacademy.springjpa.controller.rest;

import com.nhnacademy.springjpa.domain.FamilyRelationShipModifyRequest;
import com.nhnacademy.springjpa.domain.FamilyRelationShipRegisterRequest;
import com.nhnacademy.springjpa.entity.FamilyRelationShip;
import com.nhnacademy.springjpa.service.FamilyRelationShipService;
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
public class FamilyRelationController {

     private final FamilyRelationShipService familyRelationShipService;

     @PostMapping("/residents/{serialNumber}/relationship")
     public ResponseEntity<FamilyRelationShip> postFamilyRelation(
             @PathVariable("serialNumber") Integer serial,
             @RequestBody FamilyRelationShipRegisterRequest familyRelationShipRegisterRequest){

          return ResponseEntity
                  .ok(familyRelationShipService.registerFamilyRelationship(serial, familyRelationShipRegisterRequest));
     }

     @PutMapping("/residents/{serialNumber}/relationship/{familySerialNumber}")
     public ResponseEntity<FamilyRelationShip> putFamilyRelation(
             @PathVariable("serialNumber") Integer serialNumber,
             @PathVariable("familySerialNumber") Integer familySerialNumber,
             @RequestBody FamilyRelationShipModifyRequest relationShipModifyRequest){



          return ResponseEntity.ok(
                  familyRelationShipService.modifyFamilyCode(serialNumber, familySerialNumber,
                          relationShipModifyRequest)
          );
     }

     @DeleteMapping("/residents/{serialNumber}/relationship/{familySerialNumber}")
     public ResponseEntity<FamilyRelationShip> deleteFamilyRelation(
             @PathVariable("serialNumber") Integer serialNumber,
             @PathVariable("familySerialNumber") Integer familySerialNumber){

          familyRelationShipService.deleteFamilyFk(serialNumber, familySerialNumber);

          return ResponseEntity.ok().build();
     }
}
