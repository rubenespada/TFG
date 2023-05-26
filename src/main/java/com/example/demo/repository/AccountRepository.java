package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AccountModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface AccountRepository.
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Integer>{

	/**
	 * Find by usuario id.
	 *
	 * @param id the id
	 * @return the account model
	 */
	public AccountModel findByUsuarioId(Integer id);
	
}
