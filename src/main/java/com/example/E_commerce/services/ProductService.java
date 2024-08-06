package com.example.E_commerce.services;

import org.springframework.http.ResponseEntity;

import com.example.E_commerce.models.Product;

public interface ProductService {
	ResponseEntity<?> addProduct(Product product);
	ResponseEntity<?> getPrice(Long id);
	ResponseEntity<?> getStock(Long id);
	ResponseEntity<?> getDiscount(Long id);
	ResponseEntity<?> getAttributes(Long id);
	ResponseEntity<?> getAll();
	ResponseEntity<?> updateName(Long id, String name);
	ResponseEntity<?> updatePrice(Long id, int price);
	ResponseEntity<?> updateStock(Long id, int stock);
	ResponseEntity<?> updateDiscount(Long id, int discount);
	ResponseEntity<?> deleteProduct(Long id);
}
