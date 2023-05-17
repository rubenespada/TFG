package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity(name = "ShopUserProduct")
@Data
public class UserProductModel {
	
	@Id
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="idProduct" ,insertable = false, updatable=false)
	private ProductModel product;
	
	@ManyToOne
	@JoinColumn(name="idUser" ,insertable = false, updatable=false)
	private UserModel shopUser;
	
	private Integer cantidad;
	
	private LocalDate fecha;
	
	private Float coste;

}
