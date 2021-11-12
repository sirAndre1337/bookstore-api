package com.andre.bookstore.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<List<CategoryDTO>> findAll() {

		List<CategoryDTO> categories = categoryService.findAll();
		return ResponseEntity.ok().body(categories);
	}

	@PostMapping
	public ResponseEntity<Category> saveNewCategory(@RequestBody Category category) {

		category = categoryService.save(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id , @RequestBody CategoryDTO categoryDTO) {
		Category newCategory = categoryService.update(id , categoryDTO);
		return ResponseEntity.ok().body(new CategoryDTO(newCategory));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
		categoryService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
