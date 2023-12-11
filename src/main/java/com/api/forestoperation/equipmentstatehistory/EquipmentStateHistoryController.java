package com.api.forestoperation.equipmentstatehistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquipmentStateHistoryController {
	@Autowired
	EquipmentStateHistoryService equipmentStateHistory;
	
	@PostMapping("/equipment-state-history")
	public ResponseEntity<Object> saveEquipmentStateHistory(EquipmentStateHistoryDTO equipmentStateHistoryDTO){
		var savedEquipmentStateHistory = equipmentStateHistory.createStateHistory(equipmentStateHistoryDTO);
		return savedEquipmentStateHistory != null ? ResponseEntity.status(HttpStatus.OK).body("EquipmentStateHistory adicionado com sucesso") : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

}
