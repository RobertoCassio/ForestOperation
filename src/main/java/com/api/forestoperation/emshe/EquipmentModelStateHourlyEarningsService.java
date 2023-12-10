	package com.api.forestoperation.emshe;
	
	import java.util.List;

	import java.util.UUID;
	
	import org.springframework.beans.BeanUtils;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
	
	import com.api.forestoperation.equipmentmodel.EquipmentModelModel;
	import com.api.forestoperation.equipmentmodel.EquipmentModelRepository;
	import com.api.forestoperation.equipmentstate.EquipmentStateModel;
	import com.api.forestoperation.equipmentstate.EquipmentStateRepository;
	@Service
	public class EquipmentModelStateHourlyEarningsService {
		@Autowired
		EquipmentModelStateHourlyEarningsRepository emsheRepository;
		@Autowired
		EquipmentModelRepository equipmentModelRepository;
		@Autowired
		EquipmentStateRepository equipmentStateRepository;
	
		public List<EquipmentModelStateHourlyEarningsModel> getAllEmshe() {
			return emsheRepository.findAll();
		}
	
		public EquipmentModelStateHourlyEarningsModel createEmshe(EquipmentModelStateHourlyEarningsDTO emsheDTO) {
			EquipmentModelStateHourlyEarningsModel emsheModel = new EquipmentModelStateHourlyEarningsModel();
	
			BeanUtils.copyProperties(emsheDTO, emsheModel);
	
			EquipmentModelModel emsheModelInfo = emsheModel.getId().getEquipmentModel();
			EquipmentStateModel emsheStateInfo = emsheModel.getId().getEquipmentState();
			EquipmentModelStateHourlyEarningsPK emshePk = new EquipmentModelStateHourlyEarningsPK(emsheModelInfo,
					emsheStateInfo);
	
			emsheModel.setId(emshePk);
	
			return emsheRepository.save(emsheModel);
		}
	
		public EquipmentModelStateHourlyEarningsModel getEmsheByStateAndModelId(UUID modelId, UUID stateId) {
			if (doesStateExist(stateId) != null && doesModelExist(modelId) != null) {
				EquipmentModelStateHourlyEarningsPK emshePk = new EquipmentModelStateHourlyEarningsPK(doesModelExist(modelId),
						doesStateExist(stateId));
				EquipmentModelStateHourlyEarningsModel emsheModel = emsheRepository.findById(emshePk).orElse(null);
				return emsheModel;
			}
			return null;
		}
		
		
		public EquipmentModelStateHourlyEarningsModel updateEmshe(EquipmentModelStateHourlyEarningsDTO emsheDTO, UUID modelId, UUID stateId) {
			if(getEmsheByStateAndModelId(modelId, stateId) != null) {
				EquipmentModelStateHourlyEarningsModel emsheModel = new EquipmentModelStateHourlyEarningsModel();
				BeanUtils.copyProperties(stateId, emsheModel);
				
				return emsheRepository.save(emsheModel);
			}
			return null;
				
		}
		
		
		public EquipmentModelModel doesModelExist(UUID modelId) {
			EquipmentModelModel model = equipmentModelRepository.findById(modelId).orElse(null);
			if (model != null) {
				return model;
			}
			return null;
		}
		
		
		public EquipmentStateModel doesStateExist(UUID stateId) {
			EquipmentStateModel state = equipmentStateRepository.findById(stateId).orElse(null);
			if (state != null) {
				return state;
			}
			return null;
		}
	}
