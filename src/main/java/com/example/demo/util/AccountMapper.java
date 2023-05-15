package com.example.demo.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.AccountModel;

@Component
public class AccountMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public AccountDto toDto(AccountModel account) {
		return mapper.map(account, AccountDto.class);
	}
	
	public AccountModel toEntity(AccountDto account) {
		return mapper.map(account, AccountModel.class);
	}

}
