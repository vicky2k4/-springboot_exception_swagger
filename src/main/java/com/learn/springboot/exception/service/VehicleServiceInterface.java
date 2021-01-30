package com.learn.springboot.exception.service;

import java.util.List;
import java.util.UUID;

import com.learn.springboot.exception.dto.VehicleDTO;

public interface VehicleServiceInterface {

    public VehicleDTO getVehicle(UUID id);
    public List<VehicleDTO> listAllVehicles();

}
