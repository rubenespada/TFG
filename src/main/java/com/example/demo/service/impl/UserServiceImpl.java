package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.AltaUserDto;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.EmailInvalidException;
import com.example.demo.model.AccountModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.AccountMapper;
import com.example.demo.util.UserMapper;

/**
 * Implementación del servicio de usuarios
 * @author ruben
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	/** Acceso al bean del Repositorio del usuario. */
	@Autowired
	private UserRepository userRepository;
	
	/** Acceso al bean del Mapper de usuario. */
	@Autowired 
	private UserMapper userMapper;
	
	/** Acceso al bean del Mapper de cuenta. */
	@Autowired
	private AccountMapper accountMapper;
	
	/** Acceso al bean del Repositorio de la cuenta. */
	@Autowired
	private AccountRepository accountRepository;
	
	/** Acceso al bean del Codificador. */
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	/**
	 * Obtiene el usuario por id.
	 *
	 * @param id 
	 * @return userDto
	 */
	@Override
	public UserDto getUserById(Integer id) {
		return  userMapper.toDto(userRepository.findById(id).orElse(null));
	}

	/**
	 * Obtiene todos los usuarios.
	 *
	 * @return List<UserDto>
	 */
	@Override
	public List<UserDto> getAll() {
		return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
	}

	/**
	 * Crea el usuario, no se puede repetir el email.
	 *
	 * @param user
	 * @return tuserDto
	 * @throws EmailInvalidException 
	 */
	@Override
	public UserDto createUser(AltaUserDto user) throws EmailInvalidException{
		if(userRepository.findOneByEmail(user.getEmail()) == null) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userMapper.toDto(userRepository.save(userMapper.toEntity(user)));
		}else {
			throw new EmailInvalidException();
		}
	}

	/**
	 * Modifica el usuario.
	 *
	 * @param user
	 * @param id
	 * @return userDto
	 */
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

	/**
	 * Elimina el usuario.
	 *
	 * @param id
	 * @return true, if successful
	 */
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

	/**
	 * Asigna una nueva cuenta al usuario.
	 *
	 * @param account
	 * @param userId
	 * @return accountDto
	 */
	@Override
	public AccountDto setAccount(AccountDto account, Integer userId) {
		UserModel user = userRepository.findById(userId).orElse(null);
		if(user != null) {
			user.setCuenta(accountMapper.toEntity(account));
			userRepository.save(user);
			return account;
		}else {
			return null;
		}
	}
	
	/**
	 * Comprueba si el usuario existe por id.
	 *
	 * @param id
	 * @return true, if successful
	 */
	public boolean existsById(Integer id) {
	return userRepository.existsById(id);
	}
	
	/**
	 * Obtiene la cuenta del usuario.
	 *
	 * @param id
	 * @return the account
	 */
	public AccountDto getAccount(Integer userId) {
		UserModel user = userRepository.findById(userId).orElse(null);
		if(user != null) {
			AccountModel account = user.getCuenta();
			if(account != null) {
				return accountMapper.toDto(account);
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

}
