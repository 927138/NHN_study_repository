package com.nhnacademy.springjpa.domain;

import com.nhnacademy.springjpa.entity.Resident;
import java.util.Date;
import lombok.Data;

@Data
public class HouseHoldRequest {
     private Integer householdSerialNumber;
     private Integer householdResidentSerialNumber;
     private Date householdCompositionDate;
     private String householdCompositionReasonCode;
     private String currentHouseMovementAddress;
}
