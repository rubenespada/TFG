package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDto;
import com.example.demo.exception.InvalidDeleteProductException;
import com.example.demo.model.ProductModel;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.util.ProductMapper;

/**
 * Implementación del servicio de productos.
 */
@Service
public class ProductServiceImpl implements ProductService {

	/** Acceso al bean del Repositorio de producto. */
	@Autowired
	private ProductRepository productRepository;

	/** Acceso al bean del Repositorio de userProduct(Compras). */
	@Autowired
	private UserProductRepository userProductRepository;

	/** Acceso al bean del mapper de producto. */
	@Autowired
	private ProductMapper productMapper;

	/**
	 * Obtiene todos los productos.
	 *
	 * @return the all
	 */
	@Override
	public List<ProductDto> getAll() {
		return productRepository.findAll().stream().map(productMapper::toDto).collect(Collectors.toList());
	}

	/**
	 * Crea el producto.
	 *
	 * @param product
	 * @return ProductDto
	 */
	@Override
	public ProductDto createProduct(ProductDto product) {
		return productMapper.toDto(productRepository.save(productMapper.toEntity(product)));
	}

	/**
	 * Modifica el producto.
	 *
	 * @param id
	 * @param product
	 * @return ProductDto
	 */
	public ProductDto updateProduct(Integer id, ProductDto product) {
		ProductModel productModel = productRepository.findById(id).orElse(null);
		if (productModel != null) {
			productModel.setNombre(product.getNombre());
			productModel.setDescripcion(product.getDescripcion());
			productModel.setPrecio(product.getPrecio());
			productModel.setStock(product.getStock());
			if (product.getImagen() != null) {
				productModel.setImagen(product.getImagen());
			}
			productRepository.save(productModel);
			return product;
		} else {
			return null;
		}

	}

	/**
	 * Elimina el producto en caso de que no exista ninguna compra de este.
	 *
	 * @param id
	 * @throws InvalidDeleteProductException
	 */
	@Override
	public void deleteProduct(Integer id) throws InvalidDeleteProductException{
		ProductModel productModel = productRepository.findById(id).orElse(null);
		if (productModel != null) {
			if (userProductRepository.findByProductId(id).isEmpty()) {
				productRepository.delete(productModel);
			} else {
				throw new InvalidDeleteProductException();
			}
		} else {

		}

	}

}
