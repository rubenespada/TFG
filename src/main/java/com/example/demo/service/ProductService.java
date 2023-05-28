package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProductDto;

public interface ProductService {

	public List<ProductDto> getAll();
	
	public ProductDto createProduct(ProductDto product);

	public ProductDto updateProduct(Integer id, ProductDto product);
	
	public void deleteProduct(Integer id);
	
}
