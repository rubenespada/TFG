package com.example.demo.dto;

import lombok.Data;

@Data
public class AltaUserDto {
	
	private Integer id;
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private boolean admin;


}
