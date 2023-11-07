package com.api.forestoperation.model;

import java.sql.Date;

import com.api.forestoperation.pk.EquipmentPositionHistoryPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="equipment_position_history")
public class EquipmentPositionHistory {
	@EmbeddedId
	@Column(name="equipment_id")
	private EquipmentPositionHistoryPK id;
	
	@Column(name="date")
	private Date date;
	
	@Column (name="lat")
	private double lat;
	
	@Column (name="long")
	private double lon;

	public EquipmentPositionHistoryPK getId() {
		return id;
	}

	public void setId(EquipmentPositionHistoryPK id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}
	
}
