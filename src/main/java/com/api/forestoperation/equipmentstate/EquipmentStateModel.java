package com.api.forestoperation.equipmentstate;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "equipment_state")
public class EquipmentStateModel {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(name = "name")
	private String name;
	
	@Column (name = "color")
	private String color;
}
