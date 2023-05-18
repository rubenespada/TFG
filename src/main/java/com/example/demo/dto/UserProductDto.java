package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.model.ProductModel;
import com.example.demo.model.UserModel;

import lombok.Data;

@Data
public class UserProductDto {

	private Integer id;
	
	private ProductModel product;
	
	private UserModel shopUser;
	
	private Integer cantidad;
	
	private LocalDate fecha;
	
	private Float coste;

}
