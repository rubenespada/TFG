package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AccountService;
import com.example.demo.service.UserService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/user/account/{userId}")
	public ResponseEntity<?> getByUserId(@PathVariable Integer userId){
		return ResponseEntity.ok(userService.getAccount(userId));
	}
	
//	@PostMapping("account/{userId}")
//	public ResponseEntity<?> createAccount(@PathVariable Integer userId, @RequestBody AccountDto account){
//		if(userService.existsById(userId)) {
//			
//		}
//	}

}
