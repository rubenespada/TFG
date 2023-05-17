package com.example.demo.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.proyecto.springboot.model.Usuario;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{
	
	private final Usuario usuario;
	


	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.emptyList();
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return usuario.getPassword();
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario.getEmail();
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String getNombre() {
		return usuario.getNombre();
	}
	
	public void comparaString(String sisoy, String... searchArray) {
		
	}
	
	

}
