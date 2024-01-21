package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.ResidentRegisterRequest;
import com.nhnacademy.springjpa.domain.ResidentUpdateDeathRequest;
import com.nhnacademy.springjpa.entity.Resident;

public interface ResidentService {
     Resident saveResident(ResidentRegisterRequest resident);
     Resident updateDeathResident(Integer residentId, ResidentUpdateDeathRequest residentUpdateDeathRequest);
}
