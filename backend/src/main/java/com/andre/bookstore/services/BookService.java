package com.andre.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.bookstore.domain.Book;
import com.andre.bookstore.repositories.BookRepository;
import com.andre.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Book findById(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		return book.orElseThrow(() -> new ObjectNotFoundException("Book not found by id : " + id));
	}
}
