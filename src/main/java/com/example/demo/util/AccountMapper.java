package com.example.demo.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.AltaAccountDto;
import com.example.demo.model.AccountModel;

/**
 * Mapper de cuenta.
 */
@Component
public class AccountMapper {
	
	/**  Acceso al bean del modelMapper. */
	@Autowired
	private ModelMapper mapper;
	
	/**
	 * A dto de respuesta.
	 *
	 * @param account
	 * @return accountDto
	 */
	public AccountDto toDto(AccountModel account) {
		return mapper.map(account, AccountDto.class);
	}
	
	/**
	 * Account de respuesta A entidad.
	 *
	 * @param account
	 * @return accountModel
	 */
	public AccountModel toEntity(AccountDto account) {
		return mapper.map(account, AccountModel.class);
	}

	/**
	 * A dto de alta.
	 *
	 * @param account the account
	 * @return accountDto
	 */
	public AltaAccountDto altaToDto(AccountModel account) {
		return mapper.map(account, AltaAccountDto.class);
	}
	
	/**
	 * Account de alta a Entidad.
	 *
	 * @param account
	 * @return accountModel
	 */
	public AccountModel toEntity(AltaAccountDto account) {
		return mapper.map(account, AccountModel.class);
	}
}
