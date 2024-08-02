package com.example.E_commerce.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.E_commerce.models.ProductAttributes;
import com.example.E_commerce.models.ResponseMessage;
import com.example.E_commerce.repositories.ProductAtrributesRepository;

@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {

	@Autowired
	private ProductAtrributesRepository productAtrributesRepository;
	@Override
	public ResponseEntity<?> addProductAttribute(ProductAttributes productAttribute) {
		if(Objects.isNull(productAttribute))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid attributes"));

		}
		else {
			productAtrributesRepository.save(productAttribute);      
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Attributes added"));
	}

	@Override
	public ResponseEntity<?> getAll() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(productAtrributesRepository.findAll());
	}

	@Override
	public ResponseEntity<?> deleteProductAttribute(Long id) {
		if(Objects.isNull(productAtrributesRepository.findById(id)))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Not found"));

		}
		else {
			productAtrributesRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Attributes deleted"));
	}

}
