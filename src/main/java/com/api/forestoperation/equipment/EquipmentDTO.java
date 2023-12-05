package com.api.forestoperation.equipment;

import java.util.UUID;

import com.api.forestoperation.equipmentmodel.EquipmentModelModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public record EquipmentDTO(String name, UUID id, EquipmentModelModel equipmentModelModel) {
	@JsonProperty("equipment-model-id")
	private static UUID equipmentModelId;
}
