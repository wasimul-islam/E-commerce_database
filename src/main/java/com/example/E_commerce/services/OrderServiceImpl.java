package com.example.E_commerce.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.E_commerce.models.Order;
import com.example.E_commerce.models.Product;
import com.example.E_commerce.models.ResponseMessage;
import com.example.E_commerce.repositories.OrderRepository;
import com.example.E_commerce.repositories.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ResponseEntity<?> addOrder(Order order) {
		if(Objects.isNull(order))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid order"));

		}
		else {
			orderRepository.save(order);
			Optional<Product> optionalProduct = productRepository.findById(order.getProduct().getId());
			optionalProduct.get().setStockCount(optionalProduct.get().getStockCount()-order.getQuantity());
			productRepository.save(optionalProduct.get());
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Order added"));
	}

	@Override
	public ResponseEntity<?> getAll() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(orderRepository.findAll());
	}

	@Override
	public ResponseEntity<?> deleteOrder(Long id) {
		if(Objects.isNull(orderRepository.findById(id)))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Not found"));

		}
		else {
			orderRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Order deleted"));
	}

}
