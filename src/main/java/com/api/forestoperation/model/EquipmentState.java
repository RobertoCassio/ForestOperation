package com.api.forestoperation.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipment_state")
public class EquipmentState {
	@Id
	@Column(name="id")
	private UUID id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="color")
	private String color;
	
	
	
}
