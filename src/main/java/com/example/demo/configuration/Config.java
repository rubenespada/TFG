package com.example.demo.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Config {
	
	/**
	 * Model mapper.
	 *
	 * @return the model mapper
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	/**
	 * Encoder.
	 *
	 * @return the b crypt password encoder
	 */
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
