package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.FamilyRelationShipModifyRequest;
import com.nhnacademy.springjpa.domain.FamilyRelationShipRegisterRequest;
import com.nhnacademy.springjpa.entity.FamilyRelationShip;

public interface FamilyRelationShipService {
     FamilyRelationShip registerFamilyRelationship(Integer baseId, FamilyRelationShipRegisterRequest relationShipRegisterRequest);
     FamilyRelationShip modifyFamilyCode(Integer baseId, Integer familyId,
                                         FamilyRelationShipModifyRequest relationShipModifyRequest);
     void deleteFamilyFk(Integer baseId, Integer familyId);

}
