package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Class UserModel.
 */
@Entity(name="ShopUser")

/**
 * Instantiates a new user model.
 */
@Data
public class UserModel {

	/** Id del usuario. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** Nombre del usuario. */
	private String nombre;
	
	/** Apellidos del usuario. */
	private String apellidos;
	
	/** Email del usuario. */
	@Column(unique = true)
	private String email;
	
	/** Contraseña del usuario. */
	private String password;
	
	/** Indica si el usuario es admin o no. */
	private boolean admin;
	
    /** Cuenta del usuario. */
    @OneToOne(cascade = CascadeType.ALL ,orphanRemoval = true)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
	private AccountModel cuenta;
    
	/** Las compras del usuario. */
	@OneToMany(mappedBy="shopUser")
	@JsonIgnore
	private List<UserProductModel> userProduct;
}
