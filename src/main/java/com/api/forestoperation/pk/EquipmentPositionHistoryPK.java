package com.api.forestoperation.pk;

import java.io.Serializable;

import com.api.forestoperation.model.Equipment;
import com.api.forestoperation.model.EquipmentState;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
@Embeddable
public class EquipmentPositionHistoryPK implements Serializable {
	@ManyToOne
	@JoinColumn(name = "equipment_id", referencedColumnName = "id")
	private Equipment equipment;

	@ManyToOne
	@JoinColumn(name = "equipment_state_id", referencedColumnName = "id")
	private EquipmentState equipmentState;
	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
}
