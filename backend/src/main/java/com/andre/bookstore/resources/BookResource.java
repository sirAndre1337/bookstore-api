package com.andre.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andre.bookstore.domain.Book;
import com.andre.bookstore.services.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookResource {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById (@PathVariable Long id) {
		
		Book book = bookService.findById(id);
		return ResponseEntity.ok().body(book);
	}

}
