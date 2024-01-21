package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.ResidentCertificateIssueDto;
import com.nhnacademy.springjpa.domain.ResidentRegisterRequest;
import com.nhnacademy.springjpa.domain.ResidentUpdateDeathRequest;
import com.nhnacademy.springjpa.entity.Resident;
import com.nhnacademy.springjpa.exception.ResidentNotFoundException;
import com.nhnacademy.springjpa.exception.ResidentObjectNullPointException;
import com.nhnacademy.springjpa.repository.ResidentRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ResidentServiceImpl implements ResidentService{

     private final ResidentRepository residentRepository;
     @Override
     @Transactional
     public Resident saveResident(ResidentRegisterRequest resident) {
          if(Objects.isNull(resident))
               throw new ResidentObjectNullPointException();

          Resident storageResident = new Resident();
          storageResident.setResidentSerialNumber(resident.getResidentSerialNumber());
          storageResident.setResidentRegistrationNumber(resident.getResidentRegistrationNumber());
          storageResident.setName(resident.getName());
          storageResident.setGenderCode(resident.getGenderCode());
          storageResident.setBirthDate(resident.getBirthDate());
          storageResident.setDeathDate(resident.getDeathDate());
          storageResident.setBirthPlaceCode(resident.getBirthPlaceCode());
          storageResident.setRegistrationBaseAddress(resident.getRegistrationBaseAddress());
          storageResident.setDeathPlaceCode(resident.getDeathPlaceCode());
          storageResident.setDeathPlaceAddress(resident.getDeathPlaceAddress());

          return residentRepository.save(storageResident);
     }

     @Override
     @Transactional
     public Resident updateDeathResident(Integer residentId,
                                         ResidentUpdateDeathRequest residentUpdateDeathRequest) {
          Resident resident = residentRepository.findByResidentSerialNumber(residentId);
          if(Objects.isNull(resident))
               throw new ResidentNotFoundException();

          resident.setDeathDate(residentUpdateDeathRequest.getDeathDate());
          resident.setDeathPlaceCode(residentUpdateDeathRequest.getDeathPlaceCode());
          resident.setDeathPlaceAddress(residentUpdateDeathRequest.getDeathPlaceAddress());

          return residentRepository.save(resident);
     }

     @Override
     @Transactional
     public Page<ResidentCertificateIssueDto> findByAllResidents(Pageable pageable) {
          return residentRepository.getAllBy(pageable);
     }
}
