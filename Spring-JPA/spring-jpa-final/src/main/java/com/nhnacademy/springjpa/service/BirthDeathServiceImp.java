package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.BirthDeathDeleteRequest;
import com.nhnacademy.springjpa.domain.BirthDeathModifyRequest;
import com.nhnacademy.springjpa.domain.BirthDeathRegisterRequest;
import com.nhnacademy.springjpa.entity.BirthDeathReportResident;
import com.nhnacademy.springjpa.entity.Resident;
import com.nhnacademy.springjpa.exception.ResidentNotFoundException;
import com.nhnacademy.springjpa.repository.BirthDeathReportResidentRepository;
import com.nhnacademy.springjpa.repository.ResidentRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BirthDeathServiceImp implements BirthDeathService {

     private final BirthDeathReportResidentRepository reportResidentRepository;
     private final ResidentRepository residentRepository;

     @Override
     public BirthDeathReportResident birthDeathRegister(Integer serialNumber, BirthDeathRegisterRequest birthDeathRegisterRequest) {

          Resident resident = residentRepository.findByResidentSerialNumber(serialNumber);
          if(Objects.isNull(resident))
               throw new ResidentNotFoundException();

          BirthDeathReportResident.BirthDeathPK pk = new BirthDeathReportResident.BirthDeathPK();
          pk.setReportResidentSerialNumber(birthDeathRegisterRequest.getReportResidentSerialNumber());
          pk.setBirthDeathTypeCode(birthDeathRegisterRequest.getBirthDeathTypeCode());
          pk.setResidentSerialNumber(serialNumber);

          BirthDeathReportResident reportResident = new BirthDeathReportResident();
          reportResident.setBirthDeathPK(pk);

          reportResident.setBirthDeathReportDate(birthDeathRegisterRequest.getBirthDeathReportDate());
          reportResident.setResidentSerialNumber(resident);
          reportResident.setBirthReportQualificationsCode(reportResident.getBirthReportQualificationsCode());
          reportResident.setEmailAddress(birthDeathRegisterRequest.getEmailAddress());
          reportResident.setDeathReportQualificationsCode(birthDeathRegisterRequest.getDeathReportQualificationsCode());
          reportResident.setPhoneNumber(birthDeathRegisterRequest.getPhoneNumber());

          return reportResidentRepository.save(reportResident);
     }

     @Override
     public BirthDeathReportResident birthDeathModify(Integer serialNumber, Integer targetNumber,
                                                      BirthDeathModifyRequest modifyRequest) {

          BirthDeathReportResident.BirthDeathPK pk = new BirthDeathReportResident.BirthDeathPK();
          pk.setResidentSerialNumber(serialNumber);
          pk.setBirthDeathTypeCode(modifyRequest.getBirthDeathTypeCode());
          pk.setReportResidentSerialNumber(targetNumber);

          BirthDeathReportResident reportResident = reportResidentRepository.findByBirthDeathPK(pk);

          reportResident.setBirthDeathReportDate(modifyRequest.getBirthDeathReportDate());
          reportResident.setBirthReportQualificationsCode(modifyRequest.getBirthReportQualificationsCode());
          reportResident.setDeathReportQualificationsCode(modifyRequest.getDeathReportQualificationsCode());
          reportResident.setEmailAddress(modifyRequest.getEmailAddress());
          reportResident.setPhoneNumber(modifyRequest.getPhoneNumber());

          return reportResidentRepository.saveAndFlush(reportResident);
     }

     @Override
     public void birthDelete(Integer serialNumber, Integer targetNumber, BirthDeathDeleteRequest deleteRequest) {
          BirthDeathReportResident.BirthDeathPK pk = new BirthDeathReportResident.BirthDeathPK();
          pk.setResidentSerialNumber(serialNumber);
          pk.setBirthDeathTypeCode(deleteRequest.getBirthDeathTypeCode());
          pk.setReportResidentSerialNumber(targetNumber);

          reportResidentRepository.deleteByBirthDeathPK(pk);
     }
}
