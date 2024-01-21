package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.BirthDeathDeleteRequest;
import com.nhnacademy.springjpa.domain.BirthDeathModifyRequest;
import com.nhnacademy.springjpa.domain.BirthDeathRegisterRequest;
import com.nhnacademy.springjpa.entity.BirthDeathReportResident;

public interface BirthDeathService {
     BirthDeathReportResident birthDeathRegister(Integer serialNumber, BirthDeathRegisterRequest birthDeathRegisterRequest);
     BirthDeathReportResident birthDeathModify(Integer serialNumber, Integer targetNumber, BirthDeathModifyRequest modifyRequest);
     void birthDelete(Integer serialNumber, Integer targetNumber, BirthDeathDeleteRequest deleteRequest);
}
