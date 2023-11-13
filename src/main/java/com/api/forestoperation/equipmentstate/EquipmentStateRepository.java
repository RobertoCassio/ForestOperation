package com.api.forestoperation.equipmentstate;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentStateRepository extends JpaRepository<EquipmentStateModel, UUID> {

}
