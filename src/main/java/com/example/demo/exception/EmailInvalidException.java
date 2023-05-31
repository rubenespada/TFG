package com.example.demo.exception;



public class EmailInvalidException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EmailInvalidException() {
		super("El email ya está registrado");
	}
	
}
