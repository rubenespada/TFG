package com.example.demo.security;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * Clase que construye el token
 * @author ruben
 *
 */
public class TokenUtils {
	

	private final static String ACCESS_TOKEN_SECRET = "4quhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud";
	
	/**
	 * Tiempo de expiracion del token
	 */
	private final static Long ACCES_TOKEN_VALIDITY_SECONDS = 2592000L;
	
	
	
	/**
	 * Crea el token e introduce los atributos de id, si es admin o no y el nombre completo del usuario
	 * @param email
	 * @param id
	 * @param nombre
	 * @param rol
	 * @return
	 */
	public static String createToken(String email,Integer id,String nombre, boolean rol) {
		long expirationTime = ACCES_TOKEN_VALIDITY_SECONDS * 1000;
		Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
		
		Map<String, Object> extra = new HashMap();
		extra.put("id",id);
		extra.put("admin", rol);
		extra.put("nombre", nombre);
		
		return Jwts.builder()
				.setSubject(email)
				.setExpiration(expirationDate)
				.addClaims(extra)
				.signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
				.compact();
	}
	
	
	public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
		UsernamePasswordAuthenticationToken userPassAuthToken;
		try {
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
				.build()
				.parseClaimsJws(token)
				.getBody();
		
		String email = claims.getSubject();
		userPassAuthToken = new UsernamePasswordAuthenticationToken(email,null,Collections.emptyList());
		return userPassAuthToken;
		
		}catch(JwtException ex) {
		 userPassAuthToken = null;
	}
		return userPassAuthToken;
	}
	
	
}
