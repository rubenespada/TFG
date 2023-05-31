package com.example.demo.security;

import lombok.Data;

/**
 * Clase para pasar el email y la contraseña para el login
 */
@Data
public class AuthCredentials {
	private String email;
	private String password;

}
