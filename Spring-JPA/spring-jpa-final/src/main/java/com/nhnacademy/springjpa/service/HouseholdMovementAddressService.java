package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.HouseholdMovementAddressRequest;
import com.nhnacademy.springjpa.entity.HouseholdMovementAddress;
import java.util.Date;

public interface HouseholdMovementAddressService {
     HouseholdMovementAddress createHouseholdMovement(Integer householdSerialNumber);

     HouseholdMovementAddress updateHouseholdMovement(Integer householdSerialNumber, String reportDate, HouseholdMovementAddressRequest request);

     void deleteHouseholdMovement(Integer householdSerialNumber, String reportDate);
}
