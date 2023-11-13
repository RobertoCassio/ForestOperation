package com.api.forestoperation.equipment;

import java.util.UUID;

import com.api.forestoperation.equipmentmodel.EquipmentModelModel;

public record EquipmentDTO(String name, UUID id, EquipmentModelModel equipmentModelModel) {

}
