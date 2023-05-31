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

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.AltaUserDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	/** The user service. */
	@Autowired
	private UserService userService;
	
	/**
	 * Recupera el usuario meidante el id.
	 *
	 * @param id the id
	 * @return the user
	 */
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable Integer id){
		UserDto result = userService.getUserById(id);
		return ResponseEntity.ok(result);
	}
	
	/**
	 * Recupera todos los usuarios.
	 *
	 * @return the all
	 */
	@GetMapping("/user")
	public ResponseEntity<?> getAll(){
		List<UserDto> result = userService.getAll();
		return ResponseEntity.ok(result);
	}
	
	/**
	 * Crea un usuario.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	@PostMapping("/user")
	public ResponseEntity<?> addUser(@RequestBody AltaUserDto user){
		UserDto result = userService.createUser(user);
		return ResponseEntity.ok(result);
	}
	
	/**
	 * Modifica un usuario mediante un cuerpo con los nuevos datos y el id para identificarlo.
	 *
	 * @param id the id
	 * @param user the user
	 * @return the response entity
	 */
	@PutMapping("/user/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserDto user){
		UserDto result = userService.updateUser(user, id);
		return ResponseEntity.ok(result);
	}
	
	
	
	/**
	 * Elimina un usuario.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id){
		return ResponseEntity.ok(userService.deleteUser(id));
	}
	
	
	/**
	 * Asgina una nueva cuenta al usuario.
	 *
	 * @param id the id
	 * @param account the account
	 * @return the response entity
	 */
	@PutMapping("/user/{id}/account")
	public ResponseEntity<?> setUserAccount(@PathVariable Integer id, @RequestBody AccountDto account){
		AccountDto result = userService.setAccount(account, id);
		return ResponseEntity.ok(result);
	}
	
	

}
