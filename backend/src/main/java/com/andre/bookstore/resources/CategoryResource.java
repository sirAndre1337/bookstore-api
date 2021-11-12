package com.andre.bookstore.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andre.bookstore.domain.Category;
import com.andre.bookstore.dtos.CategoryDTO;
import com.andre.bookstore.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		
		Category category = categoryService.findById(id);
		return ResponseEntity.ok().body(category);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll(){
		
		List<CategoryDTO> categories = categoryService.findAll();
		return ResponseEntity.ok().body(categories);
	}
}
