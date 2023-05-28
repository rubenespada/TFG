package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.ProductModel;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.util.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<ProductDto> getAll() {
		return productRepository.findAll().stream().map(productMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public ProductDto createProduct(ProductDto product) {
		return productMapper.toDto(productRepository.save(productMapper.toEntity(product)));
	}
	
	public ProductDto updateProduct(Integer id,ProductDto product) {
		ProductModel productModel = productRepository.findById(id).orElse(null);
		if(productModel != null) {
			productModel.setNombre(product.getNombre());
			productModel.setDescripcion(product.getDescripcion());
			productModel.setPrecio(product.getPrecio());
			productModel.setStock(product.getStock());
			if(product.getImagen() != null) {
			productModel.setImagen(product.getImagen());
			}
			productRepository.save(productModel);
			return product;
		}else {
			return null;
		}
		
	}

	@Override
	public void deleteProduct(Integer id) {
		ProductModel productModel = productRepository.findById(id).orElse(null);
		if(productModel != null) {
			productRepository.delete(productModel);
		}else {
			
		}

	}



}
