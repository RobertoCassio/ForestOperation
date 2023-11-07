package com.api.forestoperation.model;

import java.sql.Date;

import com.api.forestoperation.pk.EquipmentStateHistoryPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipment_state_history")
public class EquipmentStateHistory {
	@EmbeddedId
	private EquipmentStateHistoryPK id;
	
	@Column(name="date")
	private Date date;

}
