package com.learn.springboot.exception.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "vehicle_db")
public class Vehicle {

	@Id
	private UUID id;

	private String vehicleIdentityNumber;

	private String make;

	private String model;

	private String status;

}
