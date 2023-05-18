package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity(name = "ShopUserProduct")
@Data
public class UserProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="idProduct" , updatable=false)
	private ProductModel product;
	
	@ManyToOne
	@JoinColumn(name="idUser" , updatable=false)
	private UserModel shopUser;
	
	private Integer cantidad;
	
	private LocalDate fecha;
	
	private Float coste;

}
