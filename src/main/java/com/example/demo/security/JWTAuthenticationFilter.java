package com.example.demo.security;
import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Clase que autentifica a los usuarios de la aplicación
 * @author ruben
 *
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	
	/**
	 *Este método comprueba que el login sea correcto
	 */
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

		AuthCredentials authCredentials = new AuthCredentials();

		try {
			authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
				authCredentials.getEmail(), authCredentials.getPassword(), Collections.emptyList());

		return getAuthenticationManager().authenticate(usernamePAT);

	}
	
	

	/**
	 *Una vez el login sea correcto, este método se encarga de reenviar de vuelta el token de acceso para las peticiones de la aplicación.
	 */
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
		String token = TokenUtils.createToken(userDetails.getUsername(),userDetails.getId(),userDetails.getNombre() + " " + userDetails.getApellido(),userDetails.isAdmin());

		response.addHeader("Authorization", "Bearer " + token);
		response.getWriter().flush();

		super.successfulAuthentication(request, response, chain, authResult);
	}

}
