package com.luminescent.digital.jijobedhybrisspringtestluminescent.service;

import org.springframework.stereotype.Service;

import com.luminescent.digital.jijobedhybrisspringtestluminescent.model.Product;

@Service
public interface ProductService {

	Iterable<Product> getProducts();
	Product getProductForId(Long id);
	Product save(Product product);
}
