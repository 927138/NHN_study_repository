package com.nhnacademy.springjpa.domain;

import lombok.Data;

@Data
public class FamilyRelationShipRegisterRequest {
     private Integer familySerialNumber;
     private String relationShip;
}
