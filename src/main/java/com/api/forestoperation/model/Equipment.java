package com.api.forestoperation.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table (name= "equipment")

public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idProduct;
	private String name;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private EquipmentModel Id;

	public UUID getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(UUID idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EquipmentModel getId() {
		return Id;
	}

	public void setId(EquipmentModel id) {
		Id = id;
	}
}
