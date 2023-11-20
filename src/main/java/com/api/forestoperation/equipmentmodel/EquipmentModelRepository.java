package com.api.forestoperation.equipmentmodel;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentModelRepository extends JpaRepository<EquipmentModelModel, UUID> {

}
