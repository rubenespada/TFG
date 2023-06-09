package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserProductDto;
import com.example.demo.service.UserProductService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserProductController.
 */
@RestController
@RequestMapping("/api/v1")
public class UserProductController {

	/** The user product service. */
	@Autowired
	private UserProductService userProductService;

	/**
	 * Realiza una compra y la guarda asginada a un usuario y un producto.
	 *
	 * @param userProduct the user product
	 * @return the response entity
	 */
	@PostMapping("/userProduct")
	public ResponseEntity<?> createUserProduct(@RequestBody UserProductDto userProduct){
		UserProductDto result = userProductService.createUserProduct(userProduct);
		return ResponseEntity.ok(result);

	}
	
	/**
	 * Recupera todos las compras de un usuario
	 * @param id
	 * @return
	 */
	@GetMapping("/userProduct/user/{id}")
	public ResponseEntity<?> getAllByUser(@PathVariable Integer id){
		List<UserProductDto> result = userProductService.getAllByUser(id);
		return ResponseEntity.ok(result);
	}

}
