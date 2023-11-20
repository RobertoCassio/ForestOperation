package com.api.forestoperation.equipmentmodel;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class EquipmentModelService {
	@Autowired
	private EquipmentModelRepository equipmentModelRepository;
	
	public EquipmentModelModel createEquipmentModel(@RequestBody EquipmentModelDTO equipmentModelDTO) {
		var equipmentModelModel = new EquipmentModelModel();
		BeanUtils.copyProperties(equipmentModelDTO, equipmentModelModel);
		
		return equipmentModelRepository.save(equipmentModelModel);
	}
	
	public List<EquipmentModelModel> getAllEquipmentModels(){
		return equipmentModelRepository.findAll();
	}
	
	public EquipmentModelModel getEquipmentById(UUID id) {
		var equipmentM = equipmentModelRepository.findById(id).orElse(null);
		return equipmentM;
	}
	
	public EquipmentModelModel updateProductModel(UUID id, EquipmentModelDTO equipmentModelDTO) {
		EquipmentModelModel equipmentModelModel = equipmentModelRepository.findById(id).orElse(null);
		if (equipmentModelModel != null) {
			BeanUtils.copyProperties(equipmentModelDTO, equipmentModelModel);
			return equipmentModelRepository.save(equipmentModelModel);
		}
		return null;
		
	}
	public boolean deleteEquipmentModel(UUID id) {
		EquipmentModelModel equipmentModelModel = equipmentModelRepository.findById(id).orElse(null);
		if (equipmentModelModel != null) {
			equipmentModelRepository.delete(equipmentModelModel);
			return true;
		}
		return false;
	}
}
