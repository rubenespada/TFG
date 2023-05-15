package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.UserModel;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AccountService;
import com.example.demo.util.AccountMapper;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public AccountDto getAccountById(Integer id) {
		return null;
	}

	@Override
	public List<AccountDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountDto getByUserId(Integer userId) {
		UserModel user = userRepository.findById(userId).orElse(null);
		return accountMapper.toDto(user.getCuenta());
	}

	@Override
	public AccountDto createAccount(AccountDto account, Integer userId) {
		
		return null;
	}

	@Override
	public void deleteAccount(Integer id) {
		// TODO Auto-generated method stub
		
	}
	

}
