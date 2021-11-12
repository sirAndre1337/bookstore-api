package com.andre.bookstore.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.bookstore.domain.Category;
import com.andre.bookstore.dtos.CategoryDTO;
import com.andre.bookstore.repositories.CategoryRepository;
import com.andre.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category findById(Long id) {

		Optional<Category> category = categoryRepository.findById(id);
		return category.orElseThrow(()-> new ObjectNotFoundException("Object not found! id: " + id + " Type: " + Category.class.getName()));
	}
	
	public List<CategoryDTO> findAll() {
		List<Category> list = categoryRepository.findAll();
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}
	
	public Category save(Category category) {
		category.setId(null); // Caso a categoria venha com id vai atualizar os dados, desse jeito e garantido que esse metodo so cria uma nova categoria.
		return categoryRepository.save(category);
	}
}
