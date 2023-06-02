package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

// TODO: Auto-generated Javadoc
/**
 * Implementacion del servicio de userProduct.
 */
@Service
public class UserProductServiceImpl implements UserProductService {
	
	/** Acceso al bean del Repositorio de userProduct(Compra). */
	@Autowired
	private UserProductRepository userProductRepository;
	
	/** Acceso al bean del Repositorio de cuenta. */
	@Autowired
	private AccountRepository accountRepository;
	
	/** Acceso al bean del Repositorio de usuario. */
	@Autowired
	private UserRepository userRepository;
	
	/** Acceso al bean del Repositorio de producto. */
	@Autowired
	private ProductRepository productRepository;
	
	/** Acceso al bean del mapper de userProduct(Compra). */
	@Autowired
	private UserProductMapper userProductMapper;

	/**
	 * Recupera todas las compras.
	 *
	 * @return the all
	 */
	@Override
	public List<UserProductDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Recupera todas las compras de un producto
	 *
	 * @return the all by product
	 */
	@Override
	public List<UserProductDto> getAllByProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Recupera todas las compras de un usuario.
	 *
	 * @param id
	 * @return List<UserProductDto>
	 */
	@Override
	public List<UserProductDto> getAllByUser(Integer id) {
		List<UserProductModel> purchases = userProductRepository.findByShopUserId(id);
		if(!purchases.isEmpty()) {
			return purchases.stream().map(userProductMapper::toDto).collect(Collectors.toList());
		}else {
			return null;
		}
	}

	/**
	 * Crea la compra.
	 *
	 * @param userProduct
	 * @return userProductDto
	 */
	@Override
	public UserProductDto createUserProduct(UserProductDto userProduct) {
		ProductModel product = productRepository.findById(userProduct.getProduct().getId()).orElse(null);
		UserModel user = userRepository.findById(userProduct.getShopUser().getId()).orElse(null);
		if(product != null && user != null) {
			AccountModel cuenta = user.getCuenta();
			Float coste = product.getPrecio() * userProduct.getCantidad();
			if(cuenta != null && cuenta.getSaldo() >= coste) {
			UserProductModel entitySave = userProductMapper.toEntity(userProduct);
			
			//Ajustar saldo de la cuenta
			cuenta.setSaldo(cuenta.getSaldo() - coste);
			accountRepository.save(cuenta);
			
			//Ajusta stock del producto
			product.setStock(product.getStock() - userProduct.getCantidad());
			productRepository.save(product);
			
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
