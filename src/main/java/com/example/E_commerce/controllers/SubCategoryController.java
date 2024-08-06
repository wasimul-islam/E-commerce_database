package com.example.E_commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_commerce.models.SubCategory;
import com.example.E_commerce.services.SubCategoryService;

@RestController
@RequestMapping("/sub-category")
public class SubCategoryController {

		@Autowired
		private SubCategoryService subCategoryService;
		
		@PostMapping("/add")
		public ResponseEntity<?> addSubCategory(@RequestBody SubCategory subCategory)
		{
			
			return subCategoryService.addSubCategory(subCategory);	
		}
		
		@GetMapping("/get-all")
		public ResponseEntity<?> getAll()
		{
			return subCategoryService.getAll();
		}
		
		@DeleteMapping("/delete")
		public ResponseEntity<?> deleteSubCategory(Long id)
		{
			return subCategoryService.deleteSubCategory(id);
		}
}
