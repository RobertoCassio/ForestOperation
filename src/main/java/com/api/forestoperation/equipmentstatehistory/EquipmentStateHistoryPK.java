package com.api.forestoperation.equipmentstatehistory;

import java.io.Serializable;

import com.api.forestoperation.equipment.EquipmentModel;
import com.api.forestoperation.equipmentstate.EquipmentStateModel;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class EquipmentStateHistoryPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private EquipmentModel equipmentId;
	
	@ManyToOne
	@JoinColumn(name = "equipment_state_id")
	private EquipmentStateModel equipmentStateId;
	
	
	public EquipmentModel getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(EquipmentModel equipmentId) {
		this.equipmentId = equipmentId;
	}

	public EquipmentStateModel getEquipmentStateId() {
		return equipmentStateId;
	}

	public void setEquipmentStateId(EquipmentStateModel equipmentStateId) {
		this.equipmentStateId = equipmentStateId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public EquipmentStateHistoryPK(){
		
	}
	
	public EquipmentStateHistoryPK(EquipmentModel equipmentModel, EquipmentStateModel equipmentStateModel){
		this.equipmentId = equipmentModel;
		this.equipmentStateId = equipmentStateModel;
		
	}
}
