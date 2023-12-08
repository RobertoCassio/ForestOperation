package com.api.forestoperation.emshe;

import java.io.Serializable;
import java.util.Objects;

import com.api.forestoperation.equipmentmodel.EquipmentModelModel;
import com.api.forestoperation.equipmentstate.EquipmentStateModel;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class EquipmentModelStateHourlyEarningsPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@ManyToOne
	@JoinColumn(name = "equipment_model_id" )
	private EquipmentModelModel equipmentModel;
	
	
	@ManyToOne
	@JoinColumn(name= "equipment_state_id")
	private EquipmentStateModel equipmentState;

	public EquipmentModelStateHourlyEarningsPK() {
		
	}
	public EquipmentModelStateHourlyEarningsPK(EquipmentModelModel equipmentModelModel, EquipmentStateModel equipmentStateModel) {
		this.equipmentModel = equipmentModelModel;
		this.equipmentState = equipmentStateModel;
	}
	

	
	@Override
	public int hashCode() {
		return Objects.hash(equipmentModel, equipmentState);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentModelStateHourlyEarningsPK other = (EquipmentModelStateHourlyEarningsPK) obj;
		return Objects.equals(equipmentModel, other.equipmentModel)
				&& Objects.equals(equipmentState, other.equipmentState);
	}
	public EquipmentModelModel getEquipmentModel() {
		return equipmentModel;
	}


	public void setEquipmentModel(EquipmentModelModel equipmentModel) {
		this.equipmentModel = equipmentModel;
	}


	public EquipmentStateModel getEquipmentState() {
		return equipmentState;
	}


	public void setEquipmentState(EquipmentStateModel equipmentState) {
		this.equipmentState = equipmentState;
	}
}
