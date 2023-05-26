package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserProductModel;

/**
 * The Interface UserProductRepository.
 */
@Repository
public interface UserProductRepository extends JpaRepository<UserProductModel,Integer> {

}
