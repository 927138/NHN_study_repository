package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.HouseHold;
import com.nhnacademy.springjpa.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HouseHoldRepository extends JpaRepository<HouseHold, Integer> {

     @Query("select h from HouseHold h where h.householdResidentSerialNumber = ?1")
     HouseHold getHouseHoldByHouseholdResidentSerialNumber(Resident residentSerialNumber);

}
