package com.example.demo.dto;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Se usa para recuperar los datos de un usuario.
 */
@Data
public class UserDto {
	
	/** Id del usuario. */
	private Integer id;
	
	/** Nombre del usuario. */
	private String nombre;
	
	/** Apellidos del usuario */
	private String apellidos;
	
	/** Email del usuario. */
	private String email;
	

}
