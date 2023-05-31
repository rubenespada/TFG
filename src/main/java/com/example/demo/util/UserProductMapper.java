package com.example.demo.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserProductDto;
import com.example.demo.model.UserProductModel;

/**
 * Mapper de userProduct(Compra).
 */
@Component
public class UserProductMapper {

	
	/** Acceso al bean del modelMapper. */
	@Autowired
	private ModelMapper mapper;
	
	/**
	 * A dto.
	 *
	 * @param userProduct 
	 * @return userProductDto
	 */
	public UserProductDto toDto(UserProductModel userProduct) {
		return mapper.map(userProduct, UserProductDto.class);
	}
	
	/**
	 * A entidad.
	 *
	 * @param userProduct
	 * @return userProductModel
	 */
	public UserProductModel toEntity(UserProductDto userProduct) {
		return mapper.map(userProduct, UserProductModel.class);
	}

}
