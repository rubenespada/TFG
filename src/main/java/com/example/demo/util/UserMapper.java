package com.example.demo.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.AltaUserDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.UserModel;

/**
 * Mapper de usuario.
 */
@Component
public class UserMapper {
	
	/** Acceso al bean del modelMapper. */
	@Autowired
	private ModelMapper mapper;
	
	/**
	 * A dto de respuesta.
	 *
	 * @param user
	 * @return userDto
	 */
	public UserDto toDto(UserModel user) {
		return mapper.map(user, UserDto.class);
	}
	
	/**
	 * User de respuesta A entidad.
	 *
	 * @param user the user
	 * @return the user model
	 */
	public UserModel toEntity(UserDto user) {
		return mapper.map(user, UserModel.class);
	}
	
	/**
	 * A dto de alta.
	 *
	 * @param user the user
	 * @return the alta user dto
	 */
	public AltaUserDto altaToDto(UserModel user) {
		return mapper.map(user, AltaUserDto.class);
	}
	
	/**
	 * User de alta A entidad.
	 *
	 * @param user the user
	 * @return the user model
	 */
	public UserModel toEntity(AltaUserDto user) {
		return mapper.map(user, UserModel.class);
	}

}
