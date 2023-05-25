package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserProductDto {

	private Integer id;
	
	private ProductDto product;
	
	private UserDto shopUser;
	
	private Integer cantidad;
	
	private LocalDate fecha;
	
	private Float coste;

}
