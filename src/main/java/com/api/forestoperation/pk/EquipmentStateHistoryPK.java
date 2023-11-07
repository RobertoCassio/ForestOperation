package com.api.forestoperation.pk;

import java.io.Serializable;

import com.api.forestoperation.model.Equipment;
import com.api.forestoperation.model.EquipmentState;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
@Embeddable
public class EquipmentStateHistoryPK implements Serializable{
	@ManyToOne
	private Equipment equipment;
	
	public EquipmentState getEquipmentState() {
		return equipmentState;
	}

	public void setEquipmentState(EquipmentState equipmentState) {
		this.equipmentState = equipmentState;
	}

	@ManyToOne
	private EquipmentState equipmentState;

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
}
