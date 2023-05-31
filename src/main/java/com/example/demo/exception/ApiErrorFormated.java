package com.example.demo.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiErrorFormated {
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime fecha;
	private String message;
	
	

}
