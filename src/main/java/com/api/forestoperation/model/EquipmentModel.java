package com.api.forestoperation.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table (name = "equipment_model")
public class EquipmentModel {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID Id;
	private String name;
	
	
	public UUID getId() {
		return Id;
	}
	public void setId(UUID id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
