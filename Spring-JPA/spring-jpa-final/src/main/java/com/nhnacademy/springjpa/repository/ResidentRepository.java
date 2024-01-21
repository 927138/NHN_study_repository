package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.ResidentCertificateIssueDto;
import com.nhnacademy.springjpa.entity.Resident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Integer>, ResidentRepositoryCustom {
     Resident findByResidentSerialNumber(Integer residentId);
     Page<ResidentCertificateIssueDto> getAllBy(Pageable pageable);
}
