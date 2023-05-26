package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductController.
 */
@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	/** The product service. */
	@Autowired
	private ProductService productService;
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@GetMapping("/product")
	public ResponseEntity<?> getAll(){
		List<ProductDto> result = productService.getAll();
		return ResponseEntity.ok(result);
	}

	/**
	 * Creates the product.
	 *
	 * @param product the product
	 * @return the response entity
	 */
	@PostMapping("/product")
	public ResponseEntity<?> createProduct(@RequestBody ProductDto product){
		ProductDto result = productService.createProduct(product);
		return ResponseEntity.ok(result);
	}
}
