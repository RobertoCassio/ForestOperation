package com.api.forestoperation.equipmentstatehistory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.forestoperation.equipment.EquipmentModel;
import com.api.forestoperation.equipment.EquipmentRepository;
import com.api.forestoperation.equipmentstate.EquipmentStateModel;
import com.api.forestoperation.equipmentstate.EquipmentStateRepository;

@Service
public class EquipmentStateHistoryService {
	@Autowired
	EquipmentStateHistoryRepository equipmentStateHistoryRepository;
	@Autowired
	EquipmentRepository equipmentRepository;
	@Autowired
	EquipmentStateRepository equipmentStateRepository;
	
	
	public EquipmentStateHistoryModel createStateHistory (EquipmentStateHistoryDTO equipmentStateHistoryDTO) {
		EquipmentStateHistoryModel equipmentStateHistoryModel = new EquipmentStateHistoryModel();
		if (equipmentStateHistoryDTO != null) {
			BeanUtils.copyProperties(equipmentStateHistoryDTO, equipmentStateHistoryModel);

			EquipmentModel equipment = equipmentStateHistoryModel.getId().getEquipmentId();
			EquipmentStateModel equipmentState = equipmentStateHistoryModel.getId().getEquipmentStateId();
			
			EquipmentStateHistoryPK equipmentStatePk = new EquipmentStateHistoryPK(equipment, equipmentState);
			
			equipmentStateHistoryModel.setId(equipmentStatePk);
			
			return equipmentStateHistoryRepository.save(equipmentStateHistoryModel);
		}
		else return null;
		
		
	}
}
