package com.example.demo.exception;



/**
 * Excepcion en caso de que el Email ya exista en el sistema
 * @author ruben
 *
 */
public class EmailInvalidException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EmailInvalidException() {
		super("El email ya está registrado");
	}
	
}
