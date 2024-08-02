package com.example.E_commerce.services;

import org.springframework.http.ResponseEntity;

import com.example.E_commerce.models.Cart;

public interface CartService {
	
	ResponseEntity<?> addCart(Cart cart);
	ResponseEntity<?> getAll();
	ResponseEntity<?> deleteCart(Long id);
	
}
