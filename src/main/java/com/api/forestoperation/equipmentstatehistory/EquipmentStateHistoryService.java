package com.api.forestoperation.equipmentstatehistory;

import java.util.List;
import java.util.UUID;

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
	public List<EquipmentStateHistoryModel> getAllStateHistory(){
		return equipmentStateHistoryRepository.findAll();
	}
	
	public EquipmentStateHistoryModel getEquipmentStateHistoryByStateAndEquipmentId (UUID equipmentId, UUID equipmentStateId) {
		EquipmentModel equipmentModel = equipmentRepository.findById(equipmentId).orElse(null);
		EquipmentStateModel equipmentState = equipmentStateRepository.findById(equipmentStateId).orElse(null);
		
		EquipmentStateHistoryPK equipmentStateHistoryPK = new EquipmentStateHistoryPK(equipmentModel, equipmentState);
		return equipmentStateHistoryRepository.findById(equipmentStateHistoryPK).orElse(null);
	}
	
	public EquipmentStateHistoryModel updateEquipmentStateHistory(UUID equipmentId, UUID equipmentStateId, EquipmentStateHistoryDTO equipmentStateHistoryDTO) {
		if(getEquipmentStateHistoryByStateAndEquipmentId(equipmentId, equipmentStateId) != null) {
			EquipmentStateHistoryModel equipmentStateHistoryModel = new EquipmentStateHistoryModel();
			BeanUtils.copyProperties(equipmentStateHistoryDTO, equipmentStateHistoryModel);
			
			return equipmentStateHistoryRepository.save(equipmentStateHistoryModel);
		}
		return null;
	}
}
