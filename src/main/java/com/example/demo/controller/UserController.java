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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable Integer id){
		UserDto result = userService.getUserById(id);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> getAll(){
		List<UserDto> result = userService.getAll();
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> addUser(@RequestBody UserDto user){
		UserDto result = userService.createUser(user);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserDto user){
		UserDto result = userService.updateUser(user, id);
		return ResponseEntity.ok(result);
	}
	
	
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id){
		return ResponseEntity.ok(userService.deleteUser(id));
	}
	
	
	@PutMapping("/user/{id}/account")
	public ResponseEntity<?> setUserAccount(@PathVariable Integer id, @RequestBody AccountDto account){
		AccountDto result = userService.setAccount(account, id);
		return ResponseEntity.ok(result);
	}
	
	

}
