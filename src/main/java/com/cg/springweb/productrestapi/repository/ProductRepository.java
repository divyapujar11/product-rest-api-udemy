package com.cg.springweb.productrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.springweb.productrestapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
