package com.learn.springboot.exception.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehicleDTO {
	
	private UUID id;

	private String vehicleIdentityNumber;

	private String make;

	private String model;

}
