package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.FamilyRelationShip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRelationShipRepository extends
        JpaRepository<FamilyRelationShip, FamilyRelationShip.FamilyPK> {

     FamilyRelationShip findByFamilyPK(FamilyRelationShip.FamilyPK pk);

     void deleteById(FamilyRelationShip.FamilyPK fk);
}
