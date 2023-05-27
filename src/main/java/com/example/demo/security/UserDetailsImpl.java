package com.example.demo.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.UserModel;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{
	
	private final UserModel usuario;
	


	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.emptyList();
	}
	
	public Integer getId() {
		return usuario.getId();
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
	
	public String getApellido() {
		return usuario.getApellidos();
	}
	
	public boolean isAdmin() {
		return usuario.isAdmin();
	}
	
	public void comparaString(String sisoy, String... searchArray) {
		
	}
	
	

}
