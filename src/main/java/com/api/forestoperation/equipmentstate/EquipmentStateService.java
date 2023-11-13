package com.api.forestoperation.equipmentstate;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EquipmentStateService {
	@Autowired
	private EquipmentStateRepository equipmentStateRepository;
	
	public EquipmentStateModel createEquipmentState(@RequestBody EquipmentStateDTO equipmentStateDTO) {
		var equipmentStateModel = new EquipmentStateModel();
		BeanUtils.copyProperties(equipmentStateDTO, equipmentStateModel);
		
		return equipmentStateRepository.save(equipmentStateModel);
	}
	
	public List<EquipmentStateModel> getAllEquipmentStates(){
		return equipmentStateRepository.findAll();
	}
	
	public EquipmentStateModel getEquipmentStateById(UUID id) {
		var equipmentState = equipmentStateRepository.findById(id).orElse(null);
		return equipmentState;
	}
	
	public EquipmentStateModel updateEquipmentState(UUID id, EquipmentStateDTO equipmentStateDTO) {
		EquipmentStateModel equipmentStateModel = equipmentStateRepository.findById(id).orElse(null);
		if (equipmentStateModel != null) {
			BeanUtils.copyProperties(equipmentStateDTO, equipmentStateModel);
			return equipmentStateRepository.save(equipmentStateModel);
		}
		return null;
	}
	public boolean deleteEquipmentstate(UUID id) {
		EquipmentStateModel equipmentStateModel = equipmentStateRepository.findById(id).orElse(null);
		if (equipmentStateModel != null) {
			equipmentStateRepository.delete(equipmentStateModel);
			return true;
		}
		return false;
		
	}
}
