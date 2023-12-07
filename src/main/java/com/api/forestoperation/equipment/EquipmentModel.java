package com.api.forestoperation.equipment;

import java.util.UUID;

import com.api.forestoperation.equipmentmodel.EquipmentModelModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name= "equipment", schema= "operation")

public class EquipmentModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private UUID id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="equipment_model_id")
	private EquipmentModelModel equipmentModel;
	

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
	public EquipmentModelModel getEquipmentModel() {
		return equipmentModel;
	}
	public void setEquipmentModel(EquipmentModelModel equipmentModel) {
		this.equipmentModel = equipmentModel;
	}
}