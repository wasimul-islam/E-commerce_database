package com.example.E_commerce.services;

import org.springframework.http.ResponseEntity;

import com.example.E_commerce.models.ProductAttributes;

public interface ProductAttributeService {
	ResponseEntity<?> addProductAttribute(ProductAttributes productAttribute);
	ResponseEntity<?> getAll();
	ResponseEntity<?> deleteProductAttribute(Long id);
}
