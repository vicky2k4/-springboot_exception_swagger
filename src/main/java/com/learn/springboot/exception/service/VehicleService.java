package com.learn.springboot.exception.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springboot.exception.dto.VehicleCreateDTO;
import com.learn.springboot.exception.dto.VehicleDTO;
import com.learn.springboot.exception.dto.VehicleUpdateDTO;
import com.learn.springboot.exception.model.Status;
import com.learn.springboot.exception.model.Vehicle;
import com.learn.springboot.exception.repository.VehicleRepository;

@Service
public class VehicleService implements VehicleServiceInterface {

	Logger logger = LoggerFactory.getLogger(VehicleService.class);

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public VehicleDTO getVehicle(UUID id) {
		System.out.println("UUID in service --->" + vehicleRepository.findById(id));
		if (vehicleRepository.findById(id).isPresent()) {
			logger.error("UUID--->", id);
			System.out.println("UUID in service --->" + id);
			Vehicle vehicle = vehicleRepository.findById(id).get();
			System.out.println("vehicle id --->" + vehicle.getId());
			return new VehicleDTO(vehicle.getId(), vehicle.getVehicleIdentityNumber(), vehicle.getMake(),
					vehicle.getModel());
		}
		else {
			throw new EntityNotFoundException("Vehicle Id " + id.toString() + " not found in the database");
		}

		
	}

	@Override
	public List<VehicleDTO> listAllVehicles() {
		List<VehicleDTO> vehicleDTOList = new ArrayList<>();

		vehicleRepository.findAll().forEach(vehicle -> vehicleDTOList.add(new VehicleDTO(vehicle.getId(),
				vehicle.getVehicleIdentityNumber(), vehicle.getMake(), vehicle.getModel())));
		
		if(vehicleDTOList.size() > 0) {
		return vehicleDTOList;
		}
		else
		{
			throw new EntityNotFoundException("Vehicles not found in the database");
		}
		
	}

	// custom methods based on make of vehicles
	public List<VehicleDTO> listAllVehilesbasedonMake(String make) {
		List<VehicleDTO> vehicleDTOList = new ArrayList<>();
		logger.error("make --->", make);

		vehicleRepository.findByMake(make).forEach(vehicle -> vehicleDTOList.add(new VehicleDTO(vehicle.getId(),
				vehicle.getVehicleIdentityNumber(), vehicle.getMake(), vehicle.getModel())));
		return vehicleDTOList;

	}

	public UUID saveVehicle(VehicleCreateDTO vehicleDTO) {
		Vehicle vehicle = new Vehicle();
		vehicle.setId(UUID.randomUUID());
		vehicle.setMake(vehicleDTO.getMake());
		vehicle.setModel(vehicleDTO.getModel());
		vehicle.setVehicleIdentityNumber(vehicleDTO.getVehicleIdentityNumber());
		vehicle.setStatus(String.valueOf(Status.FOR_SALE));

		return vehicleRepository.save(vehicle).getId();
	}

	public VehicleDTO updateVehicle(UUID id, VehicleUpdateDTO vehicleUpdateDTO) {
		Vehicle vehicle = null;
		if (vehicleRepository.findById(id).isPresent()) {
			vehicle = vehicleRepository.findById(id).get();
			vehicle.setMake(vehicleUpdateDTO.getMake());
			vehicle.setModel(vehicleUpdateDTO.getModel());

			Vehicle updatedVehicle = vehicleRepository.save(vehicle);

			return new VehicleDTO(updatedVehicle.getId(), updatedVehicle.getVehicleIdentityNumber(),
					updatedVehicle.getMake(), updatedVehicle.getModel());

		} else {

			throw new EntityNotFoundException("Vehicle Id " + id.toString() + " not found in the database");

		}
	}

}
