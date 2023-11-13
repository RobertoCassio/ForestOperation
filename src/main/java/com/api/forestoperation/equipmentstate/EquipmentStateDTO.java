package com.api.forestoperation.equipmentstate;

import java.util.UUID;

public record EquipmentStateDTO (String name, String color, UUID id, EquipmentStateModel equipmentStateModel) {

}
