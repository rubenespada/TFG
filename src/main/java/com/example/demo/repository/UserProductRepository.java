package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserProductModel;

/**
 * Repositorio de las compras.
 */
@Repository
public interface UserProductRepository extends JpaRepository<UserProductModel,Integer> {

	/**
	 * Recupera una compra mediante el id del usuario
	 * @param id
	 * @return
	 */
	public List<UserProductModel>findByShopUserId(Integer id);
	
	/**
	 * Recupera una compra mediante el id del producto
	 * @param id
	 * @return
	 */
	public List<UserProductModel>findByProductId(Integer id);
	
}
