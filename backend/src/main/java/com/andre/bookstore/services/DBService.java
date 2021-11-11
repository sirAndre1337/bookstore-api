package com.andre.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.bookstore.domain.Book;
import com.andre.bookstore.domain.Category;
import com.andre.bookstore.repositories.BookRepository;
import com.andre.bookstore.repositories.CategoryRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public void instaciaBaseDeDados () {
		Category cat1 = new Category(null, "Informatica", "Livro de Java");
		Category cat2 = new Category(null, "Ficcao Cientifica", "Ficcao Cientifica");
		Category cat3 = new Category(null, "Biografia", "Livro de biografias");

		Book b1 = new Book(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Book b2 = new Book(null, "Engenharia de Software", "Louis V. Gervan", "Lorem ipsum", cat1);
		Book b3 = new Book(null, "The Time Machine", "H.G. Homes", "Lorem ipsum", cat2);
		Book b4 = new Book(null, "The War of the Worlds", "H.G Brigthis", "Lorem ipsum", cat2);
		Book b5 = new Book(null, "A Biografia do Infinito", "Andre Lacerda", "Lorem ipsum", cat2);

		cat1.getBooks().addAll(Arrays.asList(b1, b2));
		cat2.getBooks().addAll(Arrays.asList(b3, b4 , b5));

		this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5));
	}

}
