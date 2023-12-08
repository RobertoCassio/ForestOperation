package com.api.forestoperation.equipmentstate;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "equipment_state", schema= "operation")
public class EquipmentStateModel {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(name = "name")
	private String name;
	
	@Column (name = "color")
	private String color;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
