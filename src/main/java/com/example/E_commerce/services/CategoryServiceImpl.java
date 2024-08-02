package com.example.E_commerce.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.E_commerce.models.Category;
import com.example.E_commerce.models.ResponseMessage;
import com.example.E_commerce.repositories.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public ResponseEntity<?> addCategory(Category category) {
		if(Objects.isNull(category))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid category"));

		}
		else {
			categoryRepository.save(category);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Category added"));
	}

	@Override
	public ResponseEntity<?> getAll() {
		
		return ResponseEntity.ok(categoryRepository.findAll());
	}

	@Override
	public ResponseEntity<?> deleteCategory(Long id) {
		if(Objects.isNull(categoryRepository.findById(id)))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Not found"));

		}
		else {
			categoryRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Category deleted"));
	}

}
