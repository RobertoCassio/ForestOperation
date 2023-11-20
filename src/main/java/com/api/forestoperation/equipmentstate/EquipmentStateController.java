package com.api.forestoperation.equipmentstate;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquipmentStateController {
	@Autowired
	EquipmentStateService equipmentStateService;
	
	@PostMapping("/EquipmentState")
	public ResponseEntity<Object> saveEquipmentState(@RequestBody EquipmentStateDTO equipmentStateDTO, UUID id){
		var savedEquipmentState = equipmentStateService.createEquipmentState(equipmentStateDTO);
		return savedEquipmentState != null ? ResponseEntity.status(HttpStatus.CREATED).body(savedEquipmentState) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/EquipmentState")
	public ResponseEntity<List<EquipmentStateModel>> getAllEquipmentStates(){
		List<EquipmentStateModel> equipmentStates = equipmentStateService.getAllEquipmentStates();
		return ResponseEntity.status(HttpStatus.OK).body(equipmentStates);
	}
}
