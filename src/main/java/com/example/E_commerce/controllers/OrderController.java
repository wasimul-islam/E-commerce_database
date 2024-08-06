package com.example.E_commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_commerce.models.Order;
import com.example.E_commerce.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

		@Autowired
		private OrderService orderService;
		
		@PostMapping("/add")
		public ResponseEntity<?> addOrder(@RequestBody Order order )
		{
			
			return orderService.addOrder(order);	
		}
		
		@GetMapping("/get-all")
		public ResponseEntity<?> getAll()
		{
			return orderService.getAll();
		}
		
		@DeleteMapping("/delete")
		public ResponseEntity<?> deleteOrdeder(Long id)
		{
			return orderService.deleteOrder(id);
		}
}
