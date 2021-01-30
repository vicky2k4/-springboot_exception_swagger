package com.learn.springboot.exception.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.learn.springboot.exception.model.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, UUID> {
	
	public List<Vehicle> findByMake(String make);

}
