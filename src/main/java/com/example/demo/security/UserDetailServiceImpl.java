package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proyecto.springboot.model.Usuario;
import com.proyecto.springboot.repository.UsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioRepository.findOneByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Email no encontrado"));
		return new UserDetailsImpl(usuario); 
	}
	 

}
