package com.andre.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andre.bookstore.domain.Book;
import com.andre.bookstore.domain.Category;
import com.andre.bookstore.repositories.BookRepository;
import com.andre.bookstore.repositories.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Informatica", "Livro de Java");

		Book b1 = new Book(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);

		cat1.getBooks().addAll(Arrays.asList(b1));

		this.categoryRepository.saveAll(Arrays.asList(cat1));
		this.bookRepository.saveAll(Arrays.asList(b1));

	}

}
