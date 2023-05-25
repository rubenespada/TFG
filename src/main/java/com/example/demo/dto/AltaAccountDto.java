package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AltaAccountDto {
	
	private Integer id;
	private Float saldo;
	private LocalDate fechaCad;
	private Integer pin;

}
