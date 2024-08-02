package com.example.E_commerce.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.E_commerce.models.Product;
import com.example.E_commerce.models.ResponseMessage;
import com.example.E_commerce.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

		@Autowired
		private ProductRepository productRepository;
	@Override
	public ResponseEntity<?> addProduct(Product product) {
		if(Objects.isNull(product))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid product"));

		}
		else {
			productRepository.save(product);      
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Product added"));
	}

	@Override
	public ResponseEntity<?> getAll() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(productRepository.findAll());
	}

	@Override
	public ResponseEntity<?> deleteProduct(Long id) {
		if(Objects.isNull(productRepository.findById(id)))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Not found"));

		}
		else {
			productRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Product deleted"));
	}

}
