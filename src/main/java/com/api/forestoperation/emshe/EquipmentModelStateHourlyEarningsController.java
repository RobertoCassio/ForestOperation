	package com.api.forestoperation.emshe;
	
	import java.util.List;
	import java.util.UUID;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;
	
	@RestController
	public class EquipmentModelStateHourlyEarningsController {
		@Autowired
		EquipmentModelStateHourlyEarningsService emsheService;
	
		@PostMapping("/equipment-model-state-hourly-earnings")
		public ResponseEntity<Object> saveEmshe(@RequestBody EquipmentModelStateHourlyEarningsDTO emsheDTO) {
			var savedEmshe = emsheService.createEmshe(emsheDTO);
			return savedEmshe != null
					? ResponseEntity.status(HttpStatus.CREATED)
							.body("EquipmentModelStateHourlyEarnings created with Sucess")
					: ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	
		@GetMapping("/equipment-model-state-hourly-earnings")
		public ResponseEntity<List<EquipmentModelStateHourlyEarningsModel>> getAllEmshe() {
			List<EquipmentModelStateHourlyEarningsModel> equipments = emsheService.getAllEmshe();
			return ResponseEntity.status(HttpStatus.OK).body(equipments);
		}
	
		@GetMapping("/equipment-model-state-hourly-earnings/{modelId}/{stateId}")
		public ResponseEntity<Object> getEmsheByModelAndStateId(@PathVariable(value = "modelId") UUID modelId,
				@PathVariable(value = "stateId") UUID stateId, EquipmentModelStateHourlyEarningsPK emshePk) {
			EquipmentModelStateHourlyEarningsModel emsheModel = emsheService.getEmsheByStateAndModelId(modelId, stateId);
			return emsheModel == null ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body("EMSHE nulo")
					: ResponseEntity.status(HttpStatus.OK).body(emsheModel);
	
		}
		
		@PutMapping("/equipment-model-state-hourly-earnings/{modelId}/{stateId}")
		public ResponseEntity<Object> updateEmshe(@PathVariable(value = "modelId")UUID modelId, @PathVariable(value="stateId") UUID stateId, @RequestBody EquipmentModelStateHourlyEarningsDTO emsheDTO){
			var savedEmshe = emsheService.createEmshe(emsheDTO);
			return savedEmshe != null
					? ResponseEntity.status(HttpStatus.CREATED)
							.body("EquipmentModelStateHourlyEarnings updated with Sucess")
					: ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
