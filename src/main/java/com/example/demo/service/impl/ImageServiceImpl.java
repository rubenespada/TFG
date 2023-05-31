package com.example.demo.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.ImageService;

/**
 * Implementación del servicio de imágenes
 * @author ruben
 *
 */
@Service
public class ImageServiceImpl implements ImageService {
	
	
	
	@Value("${media.location}")
	private String mediaLocation;
	
	private Path rootLocation;

	@Override
	@PostConstruct
	public void init() throws IOException {
		rootLocation = Paths.get(mediaLocation);
		Files.createDirectories(rootLocation);
	}

	/**
	 * Método para guardar un archivo en la ruta indicada
	 *@param file
	 *@return
	 */
	@Override
	public String store(MultipartFile file) {
		if(file.isEmpty()) {
			throw new RuntimeException("Failed to store empty file");
		}
		String filename = file.getOriginalFilename();
		Path destinationFile = rootLocation.resolve(Paths.get(filename)).normalize().toAbsolutePath();
		try(InputStream inputStream = file.getInputStream()){
			Files.copy(inputStream, destinationFile,StandardCopyOption.REPLACE_EXISTING);
			return filename;
		}catch(IOException ex) {
			throw new RuntimeException("Failed to store file.",ex);
		}
	}

	
	/**
	 * Devuelve el archivo de la ruta que se pasa por parámetro
	 *@param filename
	 *@return
	 */
	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource((file.toUri()));
			
			if(resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				//Aqui podria poner una imagen por defecto
				throw new RuntimeException("Could not read file " + filename);
			}
		}catch(MalformedURLException e) {
			throw new RuntimeException("Could not read file: " + filename);
		}
	}

}
