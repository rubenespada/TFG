package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AccountModel;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Integer>{

	public AccountModel findByUsuarioId(Integer id);
	
}
