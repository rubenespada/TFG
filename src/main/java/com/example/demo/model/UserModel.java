package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity(name="ShopUser")
@Data
public class UserModel {

	@Id
	private Integer id;
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
    @OneToOne(cascade = CascadeType.ALL ,orphanRemoval = true)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
	private AccountModel cuenta;
}
