package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.UserDto;

public interface UserService {

	public UserDto getUserById(Integer id);
	
	public List<UserDto> getAll();
	
	public UserDto createUser(UserDto user);
	
	public UserDto updateUser(UserDto user,Integer id);
	
	public boolean deleteUser(Integer id);
	
	public AccountDto setAccount(AccountDto account,Integer userId);
	
	public boolean existsById(Integer id);
	
}
