package com.api.forestoperation.equipment;

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
public class EquipmentController {
	
	@Autowired
	EquipmentService equipmentService;
	
	@PostMapping("/equipment")
	public ResponseEntity<Object> saveEquipment (@RequestBody EquipmentDTO equipmentDTO, UUID id){
			var savedEquipment = equipmentService.createEquipment(equipmentDTO);
			return savedEquipment != null ? ResponseEntity.status(HttpStatus.CREATED).body(savedEquipment) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	
	@GetMapping("/equipment")
	public ResponseEntity<List<EquipmentModel>> getAllEquipments(){
		List<EquipmentModel> equipments = equipmentService.getAllEquipments();
		return ResponseEntity.status(HttpStatus.OK).body(equipments);
	}
	
	@GetMapping("/equipment/{id}")
	public ResponseEntity<Object> getOneEquipment(@PathVariable (value = "id") UUID id){
		var equipment = equipmentService.getEquipmentById(id);
		return equipment == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipment Not Found") : ResponseEntity.status(HttpStatus.OK).body(equipment);
	}
	
	@PutMapping("/equipment/{id}")
	public ResponseEntity<Object> updateEquipment(@PathVariable (value = "id") UUID id, @RequestBody EquipmentDTO equipmentDTO){
			EquipmentModel equipment = equipmentService.updateProduct(id, equipmentDTO);
			return equipment == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipment Not Found") : ResponseEntity.status(HttpStatus.OK).body(equipment);
	}
	
	@DeleteMapping ("/equipment/delete{id}")
	public ResponseEntity<Object> deleteEquipment(@PathVariable (value = "id") UUID id){
	return equipmentService.deleteEquipment(id) ? ResponseEntity.status(HttpStatus.OK).body("Product Sucessfuly Deleted") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found");
}
}