package com.api.forestoperation.emshe;

import java.io.Serializable;

import com.api.forestoperation.equipmentmodel.EquipmentModelModel;
import com.api.forestoperation.equipmentstate.EquipmentStateModel;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="equipment_model_state_hourly_earnings", schema="operation")
public class EquipmentModelStateHourlyEarningsModel implements Serializable {
	/**
	 * 
	 */
	



	@EmbeddedId
	private EquipmentModelStateHourlyEarningsPK id;
	private static final long serialVersionUID = 1L;
	
	@Column(name="value")
	private double value;
	
	public EquipmentModelStateHourlyEarningsPK getId() {
		return id;
	}

	public void setId(EquipmentModelStateHourlyEarningsPK id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	
	public EquipmentModelModel getEquipmentModel() {
		return id.getEquipmentModel();
	}
	
	public EquipmentStateModel getEquipmentState() {
		return id.getEquipmentState();
	}

}
