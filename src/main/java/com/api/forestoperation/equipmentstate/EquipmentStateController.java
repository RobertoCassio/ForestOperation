package com.api.forestoperation.equipmentstate;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EquipmentStateController {
	@Autowired
	EquipmentStateService equipmentStateService;
	
	@PostMapping("/equipment-state")
	public ResponseEntity<Object> saveEquipmentState(@RequestBody EquipmentStateDTO equipmentStateDTO, UUID id){
		var savedEquipmentState = equipmentStateService.createEquipmentState(equipmentStateDTO);
		return savedEquipmentState != null ? ResponseEntity.status(HttpStatus.CREATED).body(savedEquipmentState) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/equipment-state")
	public ResponseEntity<List<EquipmentStateModel>> getAllEquipmentStates(){
		List<EquipmentStateModel> equipmentStates = equipmentStateService.getAllEquipmentStates();
		return ResponseEntity.status(HttpStatus.OK).body(equipmentStates);
	}
	@GetMapping("/equipment-state/{id}")
	public ResponseEntity<Object> getOneEquipment(@PathVariable (value = "id") UUID id){
		var equipmentModel = equipmentStateService.getEquipmentStateById(id);
		return equipmentModel == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipment Not Found") : ResponseEntity.status(HttpStatus.OK).body(equipmentModel);
	}
	
	@PutMapping("/equipment-state/{id}")
	public ResponseEntity<Object> updateEquipment(@PathVariable (value = "id") UUID id, @RequestBody EquipmentStateDTO equipmentStateDTO){
			EquipmentStateModel equipmentState = equipmentStateService.updateEquipmentState(id, equipmentStateDTO);
			return equipmentState == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipment Not Found") : ResponseEntity.status(HttpStatus.OK).body(equipmentState);
	}
	
	@DeleteMapping ("/equipment-state/delete{id}")
	public ResponseEntity<Object> deleteEquipmentModel(@PathVariable (value = "id") UUID id){
	return equipmentStateService.deleteEquipmentState(id) ? ResponseEntity.status(HttpStatus.OK).body("State Sucessfuly Deleted") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("State Not Found");

}
}