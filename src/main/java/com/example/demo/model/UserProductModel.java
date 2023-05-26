package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Class UserProductModel (Compra).
 */
@Entity(name = "ShopUserProduct")

/**
 * Instantiates a new user product model.
 */
@Data
public class UserProductModel {
	
	/** Id de la compra. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** Relación con el producto comprado. */
	@ManyToOne
	@JoinColumn(name="idProduct" , updatable=false)
	private ProductModel product;
	
	/** Relación con el usuario que ha realizado la compra. */
	@ManyToOne
	@JoinColumn(name="idUser" , updatable=false)
	private UserModel shopUser;
	
	/** Cantidad de unidades del producto compradas. */
	private Integer cantidad;
	
	/** Fecha de la compra. */
	private LocalDate fecha;
	
	/** Coste de la compra. */
	private Float coste;

}
