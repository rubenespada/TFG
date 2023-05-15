package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AccountDto {

	private Integer id;
	private Float saldo;
	private LocalDate fechaCad;

	
}
