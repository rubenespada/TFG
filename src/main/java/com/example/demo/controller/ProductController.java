package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	 * Recupera todos los productos.
	 *
	 * @return the all
	 */
	@GetMapping("/product")
	public ResponseEntity<?> getAll(){
		List<ProductDto> result = productService.getAll();
		return ResponseEntity.ok(result);
	}

	/**
	 * Crea un producto.
	 *
	 * @param product the product
	 * @return the response entity
	 */
	@PostMapping("/product")
	public ResponseEntity<?> createProduct(@RequestBody ProductDto product){
		ProductDto result = productService.createProduct(product);
		return ResponseEntity.ok(result);
	}
	
	/**
	 * Modifica el producto mediante el cuerpo con los nuevos datos y su id para identificarlo
	 * 
	 * @param id
	 * @param product
	 * @return
	 */
	@PutMapping("/product/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody ProductDto product){
		ProductDto result = productService.updateProduct(id,product);
		return ResponseEntity.ok(result);
	}
	
	/**
	 * Borrar producto mediante su id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
		productService.deleteProduct(id);
		return (ResponseEntity<?>) ResponseEntity.noContent();
	}
	
}
