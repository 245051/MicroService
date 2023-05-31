package com.cts.client.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.client.resource.Product;
@Service
public interface ProductService {
	

		List<Product> findAll();
		List<Product> findByCategory(String category);
		Product findById(int id);
	}


