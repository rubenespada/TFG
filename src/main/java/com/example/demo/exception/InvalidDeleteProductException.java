package com.example.demo.exception;

/**
 * Excepcion en caso de que el producto tenga una compra asignada y no se pueda borrar
 * @author ruben
 *
 */
public class InvalidDeleteProductException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public InvalidDeleteProductException() {
		super("No se puede borrar el producto");
	}

}
