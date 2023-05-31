package com.example.demo.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase para enviar una respuesta con el mensaje de la excepción y la fecha y hora a la que se ha producido
 * @author ruben
 *
 */
@Data
@AllArgsConstructor
public class ApiErrorFormated {
	

	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime fecha;
	private String message;
	
	

}
