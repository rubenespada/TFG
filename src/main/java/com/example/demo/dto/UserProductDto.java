package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Sirve tanto para recuperar las compras que ha realizado un usuario sobre un producto
 * como para darla de alta.
 */
@Data
public class UserProductDto {

	/** Id de la compra. */
	private Integer id;
	
	/** Producto que se ha comprado. */
	private ProductDto product;
	
	/** Usuario que ha realizado la compra. */
	private UserDto shopUser;
	
	/** Unidades del producto compradas. */
	private Integer cantidad;
	
	/** Fecha de la compra. */
	private LocalDate fecha;
	
	/** Coste total de la compra. */
	private Float coste;

}
