package com.example.E_commerce.services;

import org.springframework.http.ResponseEntity;

import com.example.E_commerce.models.Payment;

public interface PaymentService {
	ResponseEntity<?> addPayment(Payment payment);
	ResponseEntity<?> getAll();
	ResponseEntity<?> deletePayment(Long id);
}
