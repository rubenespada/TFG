package com.example.demo.exception;

public class InvalidDeleteProductException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public InvalidDeleteProductException() {
		super("No se puede borrar el producto");
	}

}
