package com.andre.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.bookstore.domain.Category;
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
}
