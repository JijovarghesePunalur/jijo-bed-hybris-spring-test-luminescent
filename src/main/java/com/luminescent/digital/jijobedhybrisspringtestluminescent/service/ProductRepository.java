package com.luminescent.digital.jijobedhybrisspringtestluminescent.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.luminescent.digital.jijobedhybrisspringtestluminescent.model.Product;


interface ProductRepository extends Repository<Product, Long> {

	Iterable<Product> findAll();

	Page<Product> findAll(Pageable pageable);

	Product findById(Long id);

	Product save(Product product);
}
