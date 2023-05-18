package com.example.demo.dto;

import lombok.Data;

@Data
public class ProductDto {

	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer stock;
	private Float precio;
}
