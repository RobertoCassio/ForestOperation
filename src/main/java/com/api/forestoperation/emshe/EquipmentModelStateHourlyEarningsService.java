package com.api.forestoperation.emshe;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.forestoperation.equipmentmodel.EquipmentModelRepository;
import com.api.forestoperation.equipmentstate.EquipmentStateRepository;



@Service
public class EquipmentModelStateHourlyEarningsService {
	@Autowired
	EquipmentModelStateHourlyEarningsRepository emsheRepository;
	@Autowired
	EquipmentModelRepository equipmentModelRepository;
	@Autowired
	EquipmentStateRepository equipmentStateRepository;

	
	public List<EquipmentModelStateHourlyEarningsModel> getAllEmshe(){
		return emsheRepository.findAll();
	}
	
	
	public EquipmentModelStateHourlyEarningsModel createEmshe(@RequestBody EquipmentModelStateHourlyEarningsDTO emsheDTO) {
		var emsheModel = new EquipmentModelStateHourlyEarningsModel();
		BeanUtils.copyProperties(emsheDTO, emsheModel);
		EquipmentModelStateHourlyEarningsPK emshePk = new EquipmentModelStateHourlyEarningsPK(emsheModel.getId().getEquipmentModel(), emsheModel.getId().getEquipmentState());
		emsheModel.setId(emshePk);
		return emsheRepository.save(emsheModel);
	}
	
	public EquipmentModelStateHourlyEarningsModel getEmsheByStateAndModelId(UUID modelId, UUID stateId) {
		var modelExists = equipmentModelRepository.findById(modelId).orElse(null);
		var stateExists = equipmentStateRepository.findById(stateId).orElse(null);
		if(modelExists!= null && stateExists != null) { 
		EquipmentModelStateHourlyEarningsPK emshePk = new EquipmentModelStateHourlyEarningsPK(modelExists,stateExists);
		EquipmentModelStateHourlyEarningsModel emsheModel = emsheRepository.findById(emshePk).orElse(null);
		return emsheModel;
	}
		return null;
}
}

