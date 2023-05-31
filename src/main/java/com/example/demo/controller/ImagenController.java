package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.ImageService;

import lombok.AllArgsConstructor;

/**
 * @author ruben
 *
 */
@RestController
@RequestMapping("image")
@AllArgsConstructor
public class ImagenController {

	@Autowired
	private final ImageService imageService;
	
	private final HttpServletRequest request;
	
	/**
	 * Sube una imagen a la carpeta correspondiente
	 * @param multipartFile
	 * @return
	 */
	@PostMapping("/upload")
	public Map<String,String> uploadFile(@RequestParam("file") MultipartFile multipartFile){
		String path = imageService.store(multipartFile);
		System.out.println("path" + path);
		
		return Map.of("url",path);
	}
	
	/**
	 * Recupera una imagen mediante un String con el nombre de la imagen
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	@GetMapping("{filename:.+}")
	public ResponseEntity<?> getFile(@PathVariable String filename) throws IOException{
		Resource file = imageService.loadAsResource(filename);
		String contentType = Files.probeContentType(file.getFile().toPath());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, contentType).body(file);
	}
	
}
