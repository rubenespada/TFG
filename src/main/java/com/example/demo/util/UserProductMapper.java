package com.example.demo.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserProductDto;
import com.example.demo.model.UserProductModel;

@Component
public class UserProductMapper {

	
	@Autowired
	private ModelMapper mapper;
	
	public UserProductDto toDto(UserProductModel userProduct) {
		return mapper.map(userProduct, UserProductDto.class);
	}
	
	public UserProductModel toEntity(UserProductDto userProduct) {
		return mapper.map(userProduct, UserProductModel.class);
	}

}
