package com.example.demo.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.ProductModel;

@Component
public class ProductMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public ProductDto toDto(ProductModel product) {
		return mapper.map(product, ProductDto.class);
	}
	
	public ProductModel toEntity(ProductDto product) {
		return mapper.map(product, ProductModel.class);
	}

}
