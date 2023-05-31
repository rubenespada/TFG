package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.AccountModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AccountService;
import com.example.demo.util.AccountMapper;

/**
 * Implementación del servicio de cuentas
 * @author ruben
 *
 */
@Service
public class AccountServiceImpl implements AccountService {
	
	/** Acceso al bean del repositorio de las cuentas */
	@Autowired
	private AccountRepository accountRepository;
	
	/** Acceso al bean del mapper de las cuentas */
	@Autowired
	private AccountMapper accountMapper;
	
	/** Acceso al bean del repositorio de usuarios */
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


	/**
	 * Devuelve una cuenta por usuario
	 * @param userId
	 * @return
	 *
	 */
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

	/**
	 * Modifica el saldo de la cuenta de un usuario mediante una variable float
	 *@param userId, saldo
	 *
	 */

	@Override
	public void modifyBalance(Integer userId, Float saldo) {
		UserModel user = userRepository.findById(userId).orElse(null);
		if(user != null) {
			AccountModel account = user.getCuenta();
			account.setSaldo(account.getSaldo() + saldo);
			accountRepository.save(account);
		}
		
	}
	

}
