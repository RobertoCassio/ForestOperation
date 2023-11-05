package com.api.forestoperation.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipment_position_history")
public class EquipmentPositionHistory {
	private Equipment equipmentId;
	private Date date;
	private Double lat;
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
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	private Double lon;
}
