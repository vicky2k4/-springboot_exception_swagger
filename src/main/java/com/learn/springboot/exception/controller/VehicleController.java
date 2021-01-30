package com.learn.springboot.exception.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot.exception.dto.VehicleCreateDTO;
import com.learn.springboot.exception.dto.VehicleDTO;
import com.learn.springboot.exception.dto.VehicleUpdateDTO;
import com.learn.springboot.exception.service.VehicleService;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
	
	Logger logger = LoggerFactory.getLogger(VehicleController.class);
	
	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/getVehicle/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<VehicleDTO> getVehiclefromId(@PathVariable UUID id) {
		System.out.println("UUID -->"+id);
		logger.error("UUID-->", id);
		return new ResponseEntity<>(vehicleService.getVehicle(id), HttpStatus.OK);

	}
	
	@GetMapping("/getAllVehicle")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<VehicleDTO>> getAllVehicle() {
		return new ResponseEntity<>(vehicleService.listAllVehicles(), HttpStatus.OK);

	}
	
	@GetMapping("/getVehicleMake/{make}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<VehicleDTO>> getVehiclefromId(@PathVariable String make) {
		return new ResponseEntity<>(vehicleService.listAllVehilesbasedonMake(make), HttpStatus.OK);

	}
	
	@PostMapping("/createVehicle")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UUID> createVehicle(@Valid @RequestBody VehicleCreateDTO vehicleCreateDTO) {
		return new ResponseEntity<>(vehicleService.saveVehicle(vehicleCreateDTO), HttpStatus.CREATED);

	}

	@PutMapping("/updateVehicle/{id)")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable UUID id,@Valid @RequestBody VehicleUpdateDTO vehicleUpdateDTO ) {
		return new ResponseEntity<>(vehicleService.updateVehicle(id,vehicleUpdateDTO), HttpStatus.OK);

	}
	

}
