package com.example.E_commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_commerce.models.Cart;
import com.example.E_commerce.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

		@Autowired
		private CartService cartService;
		
		@PostMapping("/add")
		public ResponseEntity<?> addCart(@RequestBody Cart cart )
		{
			
			return cartService.addCart(cart);	
		}
		
		@GetMapping("/get-all")
		public ResponseEntity<?> getAll()
		{
			return cartService.getAll();
		}
		
		@DeleteMapping("/delete")
		public ResponseEntity<?> deleteCart(Long id)
		{
			return cartService.deleteCart(id);
		}
}
