package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserModel;

// TODO: Auto-generated Javadoc
/**
 * Repositorio de los usuarios.
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{

	/**
	 * Encuentra el primer usuario con ese email.
	 *
	 * @param email the email
	 * @return the user model
	 */
	public UserModel findOneByEmail(String email);
	
}
