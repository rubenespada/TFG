package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductModel.
 */
@Entity(name="Product")

/**
 * Instantiates a new product model.
 */
@Data
public class ProductModel {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** Nombre del producto. */
	private String nombre;
	
	/** Descripción del producto. */
	private String descripcion;
	
	/** Stock del producto. */
	private Integer stock;
	
	/** Precio del producto. */
	private Float precio;
	
	private String imagen;
	
	/** Relacion con UserProductModel (compras). */
	@OneToMany(mappedBy="product")
	@JsonIgnore
	private List<UserProductModel> userProduct;
	
}
