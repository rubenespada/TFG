package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.AccountModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.AccountMapper;
import com.example.demo.util.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private UserMapper userMapper;
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public UserDto getUserById(Integer id) {
		return  userMapper.toDto(userRepository.findById(id).orElse(null));
	}

	@Override
	public List<UserDto> getAll() {
		return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public UserDto createUser(UserDto user) {
		return userMapper.toDto(userRepository.save(userMapper.toEntity(user)));
		
	}

	@Override
	public UserDto updateUser(UserDto user,Integer id) {
		UserModel userEntity = userRepository.findById(id).orElse(null);
		if(user != null) {
			userEntity.setNombre(user.getNombre());
			userEntity.setApellidos(user.getApellidos());
			userEntity.setEmail(user.getEmail());
			userRepository.save(userEntity);
		}
		return user;
	}

	@Override
	public boolean deleteUser(Integer id) {
		UserModel user = userRepository.findById(id).orElse(null);
		if(user != null) {
			userRepository.delete(user);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public AccountDto setAccount(AccountDto account, Integer userId) {
		UserModel user = userRepository.findById(userId).orElse(null);
		if(user != null) {
			
			AccountModel accountModel = accountMapper.toEntity(account);
			accountModel.setUsuario(user);
			accountRepository.save(accountModel);
			return account;
		}else {
			return null;
		}
	}
	
	public boolean existsById(Integer id) {
	return userRepository.existsById(id);
	}

}
