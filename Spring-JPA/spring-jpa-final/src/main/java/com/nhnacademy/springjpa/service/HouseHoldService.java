package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.HouseHoldRequest;
import com.nhnacademy.springjpa.entity.HouseHold;

public interface HouseHoldService {
     HouseHold registerHouseHold(HouseHoldRequest houseHoldRequest);

     void deleteHouseHold(Integer serialNumber);
}
