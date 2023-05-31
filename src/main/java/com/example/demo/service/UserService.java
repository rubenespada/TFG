package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.AltaUserDto;
import com.example.demo.dto.UserDto;

/**
 * Interfaz del servicio de los usuarios
 * @author ruben
 *
 */
public interface UserService {

	public UserDto getUserById(Integer id);
	
	public List<UserDto> getAll();
	
	public UserDto createUser(AltaUserDto user);
	
	public UserDto updateUser(UserDto user,Integer id);
	
	public boolean deleteUser(Integer id);
	
	public AccountDto setAccount(AccountDto account,Integer userId);
	
	public boolean existsById(Integer id);
	
	public AccountDto getAccount(Integer userId);
	
}
