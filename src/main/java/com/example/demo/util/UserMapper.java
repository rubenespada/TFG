package com.example.demo.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.AltaUserDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.UserModel;

@Component
public class UserMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public UserDto toDto(UserModel user) {
		return mapper.map(user, UserDto.class);
	}
	
	public UserModel toEntity(UserDto user) {
		return mapper.map(user, UserModel.class);
	}
	
	public AltaUserDto altaToDto(UserModel user) {
		return mapper.map(user, AltaUserDto.class);
	}
	
	public UserModel toEntity(AltaUserDto user) {
		return mapper.map(user, UserModel.class);
	}

}
