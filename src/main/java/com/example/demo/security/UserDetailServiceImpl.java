package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	
	@Autowired
	private UserRepository usuarioRepository;
	

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserModel usuario = usuarioRepository.findOneByEmail(email);
		if(usuario !=  null) {
		return new UserDetailsImpl(usuario); 
		}else {
			throw new UsernameNotFoundException(email);
		}
	}
	 

}
