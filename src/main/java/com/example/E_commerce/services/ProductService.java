package com.example.E_commerce.services;

import org.springframework.http.ResponseEntity;

import com.example.E_commerce.models.Product;

public interface ProductService {
	ResponseEntity<?> addProduct(Product product);
	ResponseEntity<?> getAll();
	ResponseEntity<?> deleteProduct(Long id);
}
