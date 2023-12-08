package com.api.forestoperation.equipment;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;




@Service
public class EquipmentService {
	@Autowired
	private EquipmentRepository equipmentRepository;

	
	
	public EquipmentModel createEquipment(@RequestBody EquipmentDTO equipmentDTO) {
			var equipmentModel = new EquipmentModel();
			BeanUtils.copyProperties(equipmentDTO, equipmentModel);
			return equipmentRepository.save(equipmentModel);
	}
	
	public List<EquipmentModel> getAllEquipments(){
		return equipmentRepository.findAll();
	}
	
	public EquipmentModel getEquipmentById(UUID id) {
		var equipmentO = equipmentRepository.findById(id).orElse(null);
		return equipmentO;
	}
	
	public EquipmentModel updateProduct(UUID id, EquipmentDTO equipmentDTO) {
		EquipmentModel equipmentModel = equipmentRepository.findById(id).orElse(null);
		if (equipmentModel != null) {
			BeanUtils.copyProperties(equipmentDTO, equipmentModel);
			return equipmentRepository.save(equipmentModel);
		}
		return null;
	}
	
	public boolean deleteEquipment(UUID id) {
		EquipmentModel equipmentModel = equipmentRepository.findById(id).orElse(null);
		if (equipmentModel != null) {
			equipmentRepository.delete(equipmentModel);
			return true;
		}
		return false;
	}
	
}
