package com.example.E_commerce.services;

import org.springframework.http.ResponseEntity;

import com.example.E_commerce.models.Customer;



public interface CustomerService {
	ResponseEntity<?> add(Customer customer);

	ResponseEntity<?> getAll();

	ResponseEntity<?> update(Long id, Customer customer);
	
	ResponseEntity<?> delete(Long id);
	
}
