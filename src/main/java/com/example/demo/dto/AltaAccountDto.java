package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Se usa para dar de alta una nueva cuenta de un cliente.
 */
@Data
public class AltaAccountDto {
	
	/** Id de la cuenta */
	private Integer id;
	
	/** Saldo de la cuenta. */
	private Float saldo;
	
	/** Fecha de caducidad de la cuenta. */
	private LocalDate fechaCad;
	
	/** PIN de la cuenta. Servirá como medida de seguridad para compras de grandes cantidades. */
	private Integer pin;

}
