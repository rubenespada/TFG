package com.example.demo.dto;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Se usa para dar de Alta un Usuario en el programa.
 */
@Data
public class AltaUserDto {
	
	/** Id del usuario. */
	private Integer id;
	
	/** Nombre del usuario. */
	private String nombre;
	
	/** Apellidos del usuario. */
	private String apellidos;
	
	/** Email del usuario. */
	private String email;
	
	/** Password del usuario. */
	private String password;
	
	/** Indica si el usuario es administrador de la aplicacion. */
	private boolean admin;


}
