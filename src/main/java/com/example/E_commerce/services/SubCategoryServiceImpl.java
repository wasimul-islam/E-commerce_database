package com.example.E_commerce.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.E_commerce.models.ResponseMessage;
import com.example.E_commerce.models.SubCategory;
import com.example.E_commerce.repositories.SubCategoryRepository;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
	
	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Override
	public ResponseEntity<?> addSubCategory(SubCategory subCategory) {
		
		if(Objects.isNull(subCategory))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid Sub Category"));

		}
		else {
			subCategoryRepository.save(subCategory);      
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Sub Category added"));
	}

	@Override
	public ResponseEntity<?> getAll() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(subCategoryRepository.findAll());
	}

	@Override
	public ResponseEntity<?> deleteSubCategory(Long id) {

		if(Objects.isNull(subCategoryRepository.findById(id)))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Not found"));

		}
		else {
			subCategoryRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Sub Category deleted"));
	}
	

}
