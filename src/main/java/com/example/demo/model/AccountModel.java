package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity(name="Account")
@Data
public class AccountModel {
	
	@Id
	private Integer id;
	private Float saldo;
	private LocalDate fechaCad;
	private Integer pin;
	@OneToOne(mappedBy = "cuenta")
	private UserModel usuario;
	

}
