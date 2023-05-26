package com.example.demo.dto;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Sirve tanto para dar de alta un producto como para recuperar sus datos.
 */
@Data
public class ProductDto {

	/** Id del producto. */
	private Integer id;
	
	/** Nombre del producto. */
	private String nombre;
	
	/** Descripción del producto. */
	private String descripcion;
	
	/** Cantidad de existencias del producto. */
	private Integer stock;
	
	/** Precio por unidad del producto. */
	private Float precio;
	
	private String imagen;
}
