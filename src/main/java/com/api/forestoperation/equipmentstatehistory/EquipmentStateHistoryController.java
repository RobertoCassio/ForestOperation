package com.api.forestoperation.equipmentstatehistory;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EquipmentStateHistoryController {
	@Autowired
	EquipmentStateHistoryService equipmentStateHistoryService;
	
	@PostMapping("/equipment-state-history")
	public ResponseEntity<Object> saveEquipmentStateHistory(@RequestBody EquipmentStateHistoryDTO equipmentStateHistoryDTO){
		EquipmentStateHistoryModel savedEquipmentStateHistory = equipmentStateHistoryService.createStateHistory(equipmentStateHistoryDTO);
		return savedEquipmentStateHistory != null ? ResponseEntity.status(HttpStatus.OK).body("EquipmentStateHistory adicionado com sucesso" + savedEquipmentStateHistory) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	@GetMapping ("/equipment-state-history")
	public ResponseEntity<List<EquipmentStateHistoryModel>> getAllEquipmentStateHistory(){
		 List<EquipmentStateHistoryModel> equipmentStateHistoryList = equipmentStateHistoryService.getAllStateHistory();
		 return equipmentStateHistoryList != null ? ResponseEntity.status(HttpStatus.OK).body(equipmentStateHistoryList) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	@GetMapping ("/equipment-state-history/{equipmentId}/{stateId}")
	public ResponseEntity<Object> getEquipmentStateHistoryByIdAndState(@PathVariable(value = "equipmentId") UUID equipmentId, @PathVariable (value = "stateId") UUID stateId){
		EquipmentStateHistoryModel equipmentStateHistory = equipmentStateHistoryService.getEquipmentStateHistoryByStateAndEquipmentId(equipmentId, stateId);
		return equipmentStateHistory != null ? ResponseEntity.status(HttpStatus.OK).body(equipmentStateHistory) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

}
