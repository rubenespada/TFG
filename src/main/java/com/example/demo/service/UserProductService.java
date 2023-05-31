package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserProductDto;


/**
 * Interfaz del servicio de UserProduct(Compras)
 * @author ruben
 *
 */
public interface UserProductService {
	
	public List<UserProductDto> getAll();
	
	public List<UserProductDto> getAllByProduct();
	
	public List<UserProductDto> getAllByUser(Integer id);
	
	public UserProductDto createUserProduct(UserProductDto userProduct);

}
