package com.api.forestoperation.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipment_state_history")
public class EquipmentStateHistory {
	private Equipment equipmentId;
	private Date date;
	private EquipmentState equipmentStateId;
	
	public Equipment getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(Equipment equipmentId) {
		this.equipmentId = equipmentId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public EquipmentState getEquipmentStateId() {
		return equipmentStateId;
	}
	public void setEquipmentStateId(EquipmentState equipmentStateId) {
		this.equipmentStateId = equipmentStateId;
	}
}
