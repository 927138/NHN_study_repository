package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.HouseHoldRequest;
import com.nhnacademy.springjpa.entity.HouseHold;
import com.nhnacademy.springjpa.entity.HouseholdCompositionResident;
import com.nhnacademy.springjpa.entity.Resident;
import com.nhnacademy.springjpa.exception.HouseHoldExistsException;
import com.nhnacademy.springjpa.exception.ResidentNotFoundException;
import com.nhnacademy.springjpa.repository.HouseHoldRepository;
import com.nhnacademy.springjpa.repository.HouseholdCompositionResidentRepository;
import com.nhnacademy.springjpa.repository.ResidentRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HouseHoldServiceIml implements HouseHoldService {

     private final HouseHoldRepository houseHoldRepository;
     private final HouseholdCompositionResidentRepository householdCompositionResidentRepository;
     private final ResidentRepository residentRepository;

     @Override
     @Transactional
     public HouseHold registerHouseHold(HouseHoldRequest houseHoldRequest) {
          Resident storageResident = residentRepository.findByResidentSerialNumber(
                  houseHoldRequest.getHouseholdResidentSerialNumber()
          );
          if(Objects.isNull(storageResident))
               throw new ResidentNotFoundException();

          HouseHold storageHouseHold =
                  houseHoldRepository.getHouseHoldByHouseholdResidentSerialNumber(storageResident);
          if(Objects.nonNull(storageHouseHold))
               throw new HouseHoldExistsException();

          storageHouseHold = new HouseHold();
          storageHouseHold.setHouseholdSerialNumber(2);
          storageHouseHold.setHouseholdResidentSerialNumber(storageResident);
          storageHouseHold.setCurrentHouseMovementAddress(houseHoldRequest.getCurrentHouseMovementAddress());
          storageHouseHold.setHouseholdCompositionDate(houseHoldRequest.getHouseholdCompositionDate());
          storageHouseHold.setHouseholdCompositionReasonCode(houseHoldRequest.getHouseholdCompositionReasonCode());


          return houseHoldRepository.save(storageHouseHold);
     }

     @Override
     @Transactional
     public void deleteHouseHold(Integer serialNumber) {
          houseHoldRepository.deleteById(serialNumber);
     }
}
