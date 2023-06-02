package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.ApiErrorFormated;
import com.example.demo.exception.EmailInvalidException;
import com.example.demo.exception.InvalidDeleteProductException;

/**
 * @author ruben
 * Recoge todas las siguientes excepciones en el momento en el que se lanzan y devuelve un response personalizado dependiendo de la excepcion
 *
 */
@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(EmailInvalidException.class)
	public ResponseEntity<ApiErrorFormated> EmailInvalidException(EmailInvalidException exception){
		ApiErrorFormated apiError = new ApiErrorFormated(LocalDateTime.now(), exception.getMessage());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
	}
	
	@ExceptionHandler(InvalidDeleteProductException.class)
	public ResponseEntity<ApiErrorFormated> InvalidDeleteProductException(InvalidDeleteProductException exception){
		ApiErrorFormated apiError = new ApiErrorFormated(LocalDateTime.now(), exception.getMessage());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
	}

}
