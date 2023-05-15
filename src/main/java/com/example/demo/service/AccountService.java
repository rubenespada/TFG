package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AccountDto;

public interface AccountService {
	
	public AccountDto getAccountById(Integer id);
	
	public List<AccountDto> getAll();
	
	public AccountDto getByUserId(Integer userId);
	
	public AccountDto createAccount(AccountDto account,Integer userId);
	
	public void deleteAccount(Integer id);
	
	

}
