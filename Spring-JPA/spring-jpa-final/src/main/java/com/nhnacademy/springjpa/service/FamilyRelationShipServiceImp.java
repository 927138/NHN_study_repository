package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.FamilyRelationShipModifyRequest;
import com.nhnacademy.springjpa.domain.FamilyRelationShipRegisterRequest;
import com.nhnacademy.springjpa.entity.FamilyRelationShip;
import com.nhnacademy.springjpa.entity.Resident;
import com.nhnacademy.springjpa.exception.ResidentNotFoundException;
import com.nhnacademy.springjpa.repository.FamilyRelationShipRepository;
import com.nhnacademy.springjpa.repository.ResidentRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FamilyRelationShipServiceImp implements FamilyRelationShipService {

     private final FamilyRelationShipRepository familyRelationShipRepository;
     private final ResidentRepository residentRepository;

     public FamilyRelationShip registerFamilyRelationship(Integer baseId,
                                                          FamilyRelationShipRegisterRequest relationShipRegisterRequest) {
          Resident resident = residentRepository.findByResidentSerialNumber(baseId);
          if (Objects.isNull(resident)) {
               throw new ResidentNotFoundException();
          }

          FamilyRelationShip.FamilyPK familyPK = new FamilyRelationShip.FamilyPK();
          familyPK.setFamilyResidentSerialNumber(relationShipRegisterRequest.getFamilySerialNumber());
          familyPK.setBaseResidentSerialNumber(resident.getResidentSerialNumber());

          FamilyRelationShip familyRelationship = new FamilyRelationShip();
          familyRelationship.setFamilyPK(familyPK);
          familyRelationship.setFamilyRelationshipCode(relationShipRegisterRequest.getRelationShip());
          familyRelationship.setBaseResidentSerialNumber(resident);

          return familyRelationShipRepository.save(familyRelationship);
     }

     public FamilyRelationShip modifyFamilyCode(Integer baseId, Integer familyId,
                                                FamilyRelationShipModifyRequest relationShipModifyRequest) {

          FamilyRelationShip.FamilyPK pk = new FamilyRelationShip.FamilyPK();
          pk.setFamilyResidentSerialNumber(familyId);
          pk.setBaseResidentSerialNumber(baseId);

          FamilyRelationShip storageFamilyRelation = familyRelationShipRepository.findByFamilyPK(pk);
          storageFamilyRelation.setFamilyRelationshipCode(relationShipModifyRequest.getRelationShip());

          return familyRelationShipRepository.save(storageFamilyRelation);
     }

     @Override
     public void deleteFamilyFk(Integer baseId, Integer familyId) {

          FamilyRelationShip.FamilyPK pk = new FamilyRelationShip.FamilyPK();
          pk.setFamilyResidentSerialNumber(familyId);
          pk.setBaseResidentSerialNumber(baseId);

          familyRelationShipRepository.deleteById(pk);
     }
}
