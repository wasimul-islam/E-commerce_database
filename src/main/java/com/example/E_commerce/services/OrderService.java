package com.example.E_commerce.services;

import org.springframework.http.ResponseEntity;

import com.example.E_commerce.models.Order;

public interface OrderService {
	ResponseEntity<?> addOrder(Order order);
	ResponseEntity<?> getAll();
	ResponseEntity<?> deleteOrder(Long id);
}