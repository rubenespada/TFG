package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// TODO: Auto-generated Javadoc
/**
 * The Class DemoApplication.
 */
@SpringBootApplication  //(exclude = SecurityAutoConfiguration.class)
public class DemoApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	/**
	 * Cors configurer.
	 *
	 * @return the web mvc configurer
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/login").allowedOrigins("http://localhost:4200").allowedMethods("*")
						.exposedHeaders("*").allowedHeaders("*");
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

}
