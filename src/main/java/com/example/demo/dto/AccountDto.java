package com.example.demo.dto;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Este Dto servirá para recuperar los datos necesarios para informar al cliente del estado de su cuenta
 */
@Data
public class AccountDto {

	/** Id de la cuenta. */
	private Integer id;
	
	/** Saldo de la cuenta. */
	private Float saldo;
	
}
