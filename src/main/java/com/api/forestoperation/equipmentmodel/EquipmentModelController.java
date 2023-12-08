package com.api.forestoperation.equipmentmodel;

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
public class EquipmentModelController {
	
	@Autowired
	EquipmentModelService equipmentModelService;
	
	@PostMapping("/equipment-model")
	public ResponseEntity<Object> saveEquipment (@RequestBody EquipmentModelDTO equipmentModelDTO, UUID id){
			var savedEquipment = equipmentModelService.createEquipmentModel(equipmentModelDTO);
			return savedEquipment != null ? ResponseEntity.status(HttpStatus.CREATED).body(savedEquipment) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	
	@GetMapping("/equipment-model")
	public ResponseEntity<List<EquipmentModelModel>> getAllEquipmentModels(){
		List<EquipmentModelModel> equipmentsModels = equipmentModelService.getAllEquipmentModels();
		return ResponseEntity.status(HttpStatus.OK).body(equipmentsModels);
	}
	
	@GetMapping("/equipment-model/{id}")
	public ResponseEntity<Object> getOneEquipment(@PathVariable (value = "id") UUID id){
		var equipmentModel = equipmentModelService.getEquipmentById(id);
		return equipmentModel == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipment Not Found") : ResponseEntity.status(HttpStatus.OK).body(equipmentModel);
	}
	
	@PutMapping("/equipment-model/{id}")
	public ResponseEntity<Object> updateEquipment(@PathVariable (value = "id") UUID id, @RequestBody EquipmentModelDTO equipmentModelDTO){
			EquipmentModelModel equipmentModel = equipmentModelService.updateProductModel(id, equipmentModelDTO);
			return equipmentModel == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipment Not Found") : ResponseEntity.status(HttpStatus.OK).body(equipmentModel);
	}
	
	@DeleteMapping ("/equipment-model/delete/{id}")
	public ResponseEntity<Object> deleteEquipmentModel(@PathVariable (value = "id") UUID id){
	return equipmentModelService.deleteEquipmentModel(id) ? ResponseEntity.status(HttpStatus.OK).body("Product Sucessfuly Deleted") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found");
}
}

