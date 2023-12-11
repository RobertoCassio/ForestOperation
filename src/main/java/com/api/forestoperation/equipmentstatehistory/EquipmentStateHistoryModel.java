package com.api.forestoperation.equipmentstatehistory;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="equipment_state_history", schema="operation")
public class EquipmentStateHistoryModel {
	@EmbeddedId
	private EquipmentStateHistoryPK id;
	
	@Column(name = "date")
	private Date date;

	

	@Override
	public int hashCode() {
		return Objects.hash(date, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentStateHistoryModel other = (EquipmentStateHistoryModel) obj;
		return Objects.equals(date, other.date) && Objects.equals(id, other.id);
	}

	public EquipmentStateHistoryPK getId() {
		return id;
	}

	public void setId(EquipmentStateHistoryPK id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
