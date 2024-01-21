package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.BirthDeathReportResident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface BirthDeathReportResidentRepository
        extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.BirthDeathPK> {
     BirthDeathReportResident findByBirthDeathPK(BirthDeathReportResident.BirthDeathPK pk);

     @Transactional
     void deleteByBirthDeathPK(BirthDeathReportResident.BirthDeathPK pk);
}
