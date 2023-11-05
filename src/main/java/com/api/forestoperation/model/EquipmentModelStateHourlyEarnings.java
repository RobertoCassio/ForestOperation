package com.api.forestoperation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipment_model_state_hourly_earnings")
public class EquipmentModelStateHourlyEarnings {
	private EquipmentModel modelId;
	private EquipmentState stateId;
	private float value;
	
	public EquipmentModel getModelId() {
		return modelId;
	}
	public void setModelId(EquipmentModel modelId) {
		this.modelId = modelId;
	}
	public EquipmentState getStateId() {
		return stateId;
	}
	public void setStateId(EquipmentState stateId) {
		this.stateId = stateId;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
}
