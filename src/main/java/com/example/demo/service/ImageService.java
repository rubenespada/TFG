package com.example.demo.service;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * Interfaz del servicio de imagenes
 * @author ruben
 *
 */
public interface ImageService {
	
	void init() throws IOException;
	
	String store(MultipartFile file);
	
	Resource loadAsResource(String filename);

}
