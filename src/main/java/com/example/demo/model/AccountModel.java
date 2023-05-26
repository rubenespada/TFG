package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Class AccountModel.
 */
@Entity(name="Account")

/**
 * Instantiates a new account model.
 */
@Data
public class AccountModel {
	
	/** Id de la cuenta. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** Saldo de la cuenta. */
	private Float saldo;
	
	/** Fecha de caducidad de la cuente. */
	private LocalDate fechaCad;
	
	/** PIN de la cuenta. */
	private Integer pin;
	
	/** Relacion con usuario. */
	@OneToOne(mappedBy = "cuenta")
	private UserModel usuario;
	

}
