package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.FamilyRelationDto;
import com.nhnacademy.springjpa.entity.FamilyRelationShip;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FamilyRelationShipRepository extends
        JpaRepository<FamilyRelationShip, FamilyRelationShip.FamilyPK>{

     FamilyRelationShip findByFamilyPK(FamilyRelationShip.FamilyPK pk);
     void deleteById(FamilyRelationShip.FamilyPK fk);
}
