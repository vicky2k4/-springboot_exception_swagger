package com.learn.springboot.exception.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleUpdateDTO {
	@NotNull
	@Size(max = 10, message = "Make of Vehicle cannot have more than 10 characters")
	private String make;

	@NotNull
	@Size(max = 10, message = "Model of Vehicle cannot have more than 10 characters")
	private String model;

}
