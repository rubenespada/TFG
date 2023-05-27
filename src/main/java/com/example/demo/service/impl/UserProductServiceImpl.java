package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserProductDto;
import com.example.demo.model.AccountModel;
import com.example.demo.model.ProductModel;
import com.example.demo.model.UserModel;
import com.example.demo.model.UserProductModel;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserProductService;
import com.example.demo.util.UserProductMapper;

@Service
public class UserProductServiceImpl implements UserProductService {
	
	@Autowired
	private UserProductRepository userProductRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserProductMapper userProductMapper;

	@Override
	public List<UserProductDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserProductDto> getAllByProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserProductDto> getAllByUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserProductDto createUserProduct(UserProductDto userProduct) {
		ProductModel product = productRepository.findById(userProduct.getProduct().getId()).orElse(null);
		UserModel user = userRepository.findById(userProduct.getShopUser().getId()).orElse(null);
		if(product != null && user != null) {
			AccountModel cuenta = user.getCuenta();
			Float coste = product.getPrecio() * userProduct.getCantidad();
			if(cuenta != null && cuenta.getSaldo() >= coste) {
			UserProductModel entitySave = userProductMapper.toEntity(userProduct);
			cuenta.setSaldo(cuenta.getSaldo() - coste);
			accountRepository.save(cuenta);
			entitySave.setCoste(product.getPrecio() * userProduct.getCantidad());
			entitySave.setFecha(LocalDate.now());
			entitySave.setProduct(product);
			entitySave.setShopUser(user);
			return userProductMapper.toDto(userProductRepository.save(entitySave));
			}
			
			throw new RuntimeException("No hay suficiente saldo o no hay una cuenta asociada");
		}else {
			return null;
		}
	}



}
