package com.example.E_commerce.services;

import java.util.Objects;
import java.util.Optional;

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

	@Override
	public ResponseEntity<?> getAttributes(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent())
				{
				return ResponseEntity.ok(optionalProduct.get().getProductAttributeList());
				}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid product id"));
	}

	@Override
	public ResponseEntity<?> getPrice(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent())
				{
				return ResponseEntity.ok(optionalProduct.get().getPrice());
				}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid product id"));
	}
	
	@Override
	public ResponseEntity<?> getDiscount(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent())
				{
				return ResponseEntity.ok(optionalProduct.get().getDiscount());
				}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid product id"));
	}

	@Override
	public ResponseEntity<?> getStock(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent())
				{
				return ResponseEntity.ok(optionalProduct.get().getStockCount());
				}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid product id"));
	}

	@Override
	public ResponseEntity<?> updateName(Long id, String name) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent())
				{
				optionalProduct.get().setName(name);
				productRepository.save(optionalProduct.get());
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Product name updated"));
				}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid product id"));
	}

	@Override
	public ResponseEntity<?> updatePrice(Long id, int price) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent())
				{
				optionalProduct.get().setPrice(price);
				productRepository.save(optionalProduct.get());
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Product price updated"));
				}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid product id"));
	}

	@Override
	public ResponseEntity<?> updateStock(Long id, int stock) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent())
				{
				optionalProduct.get().setStockCount(stock);
				productRepository.save(optionalProduct.get());
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Product stock updated"));
				}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid product id"));
	}

	@Override
	public ResponseEntity<?> updateDiscount(Long id, int discount) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent())
				{
				optionalProduct.get().setDiscount(discount);
				productRepository.save(optionalProduct.get());
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Product price updated"));
				}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid product id"));
	}

}
