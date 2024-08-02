package com.example.E_commerce.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.E_commerce.models.Cart;
import com.example.E_commerce.models.ResponseMessage;
import com.example.E_commerce.repositories.CartRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;

	@Override
	public ResponseEntity<?> addCart(Cart cart) {
		if(Objects.isNull(cart))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid name"));

		}
		else {
			cartRepository.save(cart);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Cart added"));
	}

	@Override
	public ResponseEntity<?> getAll() {
		
		return ResponseEntity.ok(cartRepository.findAll());
	}

	@Override
	public ResponseEntity<?> deleteCart(Long id) {
		if(Objects.isNull(cartRepository.findById(id)))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Not found"));

		}
		else {
			cartRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Cart deleted"));
	}
	
	
}
