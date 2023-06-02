package com.example.demo.security;

import lombok.Data;

/**
 * Clase para pasar el email y la password para el login
 */
@Data
public class AuthCredentials {
	private String email;
	private String password;

}
