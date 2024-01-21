package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.HouseholdCompositionResident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdCompositionResidentRepository
     extends JpaRepository<HouseholdCompositionResident, HouseholdCompositionResident.CompositionResidentPk> {
}
