package com.example.demo.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.ProductModel;

/**
 * Mapper de producto.
 */
@Component
public class ProductMapper {
	
	/** Acceso al bean del modelMapper. */
	@Autowired
	private ModelMapper mapper;
	
	/**
	 * A dto.
	 *
	 * @param product
	 * @return productDto
	 */
	public ProductDto toDto(ProductModel product) {
		return mapper.map(product, ProductDto.class);
	}
	
	/**
	 * A entidad.
	 *
	 * @param product
	 * @return productModel
	 */
	public ProductModel toEntity(ProductDto product) {
		return mapper.map(product, ProductModel.class);
	}

}
