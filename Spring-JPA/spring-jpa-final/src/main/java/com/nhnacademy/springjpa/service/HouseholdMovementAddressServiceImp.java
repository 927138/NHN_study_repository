package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.HouseholdMovementAddressRequest;
import com.nhnacademy.springjpa.entity.HouseHold;
import com.nhnacademy.springjpa.entity.HouseholdMovementAddress;
import com.nhnacademy.springjpa.entity.Resident;
import com.nhnacademy.springjpa.exception.HouseHoldExistsException;
import com.nhnacademy.springjpa.exception.HouseHoldNotFoundException;
import com.nhnacademy.springjpa.exception.ResidentNotFoundException;
import com.nhnacademy.springjpa.repository.HouseHoldRepository;
import com.nhnacademy.springjpa.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.springjpa.repository.ResidentRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HouseholdMovementAddressServiceImp implements HouseholdMovementAddressService{

     private final HouseHoldRepository houseHoldRepository;
     private final HouseholdMovementAddressRepository addressRepository;
     @Override
     public HouseholdMovementAddress createHouseholdMovement(Integer householdSerialNumber) {
          HouseHold storageHouseHold = houseHoldRepository.findById(householdSerialNumber).get();


          HouseholdMovementAddress.MovementAddressPk pk = new HouseholdMovementAddress.MovementAddressPk();
          pk.setHouseholdSerialNumber(householdSerialNumber);
          pk.setHouseMovementReportDate(storageHouseHold.getHouseholdCompositionDate());

          HouseholdMovementAddress address = addressRepository.findByMovementAddressPk(pk);
          if(Objects.nonNull(address))
               throw new HouseHoldExistsException();

          address = new HouseholdMovementAddress();
          address.setMovementAddressPk(pk);
          address.setLastAddressVn("Y");
          address.setHouseholdSerialNumber(storageHouseHold);
          address.setHouseMovementAddress(storageHouseHold.getCurrentHouseMovementAddress());


          return addressRepository.save(address);
     }

     @Override
     public HouseholdMovementAddress updateHouseholdMovement(Integer householdSerialNumber, String reportDate,
                                                             HouseholdMovementAddressRequest request) {
          HouseholdMovementAddress address = addressRepository.findPkBy(householdSerialNumber, stringTypeToDateType(reportDate));
          if(Objects.isNull(address))
               throw new HouseHoldNotFoundException();
          address.setHouseMovementAddress(request.getHouseMovementAddress());

          return addressRepository.saveAndFlush(address);
     }

     @Override
     public void deleteHouseholdMovement(Integer householdSerialNumber, String reportDate) {
          HouseholdMovementAddress.MovementAddressPk pk = new HouseholdMovementAddress.MovementAddressPk();
          pk.setHouseholdSerialNumber(householdSerialNumber);
          Date date = stringTypeToDateType(reportDate);
          pk.setHouseMovementReportDate(date);

          HouseholdMovementAddress householdMovementAddress = addressRepository.findByMovementAddressPk(pk);
          if(Objects.isNull(householdMovementAddress))
               throw new ResidentNotFoundException();

          addressRepository.delete(householdMovementAddress);

     }

     private Date stringTypeToDateType(String reportDate){
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          Date date = null;

          try {
               date = dateFormat.parse(reportDate);
          } catch (ParseException e) {
               e.printStackTrace();
          }
          return date;
     }
}
