package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDto;
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

}
