package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.ResidentCertificateIssueDto;
import com.nhnacademy.springjpa.domain.ResidentRegisterRequest;
import com.nhnacademy.springjpa.domain.ResidentUpdateDeathRequest;
import com.nhnacademy.springjpa.entity.Resident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ResidentService {
     Resident saveResident(ResidentRegisterRequest resident);
     Resident updateDeathResident(Integer residentId, ResidentUpdateDeathRequest residentUpdateDeathRequest);

     Page<ResidentCertificateIssueDto> findByAllResidents(Pageable pageable);
}
