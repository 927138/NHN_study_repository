package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.HouseHold;
import com.nhnacademy.springjpa.entity.HouseholdMovementAddress;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HouseholdMovementAddressRepository
          extends JpaRepository<HouseholdMovementAddress, HouseholdMovementAddress.MovementAddressPk> {
     HouseholdMovementAddress findByMovementAddressPk(HouseholdMovementAddress.MovementAddressPk movementAddressPk);

     @Query("select h from HouseholdMovementAddress h " +
             "where h.movementAddressPk.householdSerialNumber = ?1 " +
             "and h.movementAddressPk.houseMovementReportDate = ?2")
     HouseholdMovementAddress findPkBy(Integer id, Date date);


}
