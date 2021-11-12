package com.andre.bookstore.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andre.bookstore.domain.Book;
import com.andre.bookstore.dtos.BookDTO;
import com.andre.bookstore.services.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookResource {

	@Autowired
	private BookService bookService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Long id) {

		Book book = bookService.findById(id);
		return ResponseEntity.ok().body(book);
	}

	@GetMapping
	public ResponseEntity<List<BookDTO>> findAll(
			@RequestParam(value = "category", defaultValue = "0") Long id_category) {

		List<BookDTO> booksDTO = bookService.findAll(id_category);
		return ResponseEntity.ok().body(booksDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book) {

		Book newBook = bookService.update(id, book);
		return ResponseEntity.ok().body(newBook);
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<Book> updatePatch(@PathVariable Long id, @RequestBody Book book) {

		Book newBook = bookService.update(id, book);
		return ResponseEntity.ok().body(newBook);
	}
	
	@PostMapping
	public ResponseEntity<Book> saveNewBook(@RequestParam(value = "category" , defaultValue = "0") Long id_category ,  @RequestBody Book book) {
		
		 book = bookService.save(book , id_category);
		 URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("book/{id}").buildAndExpand(book.getId()).toUri();
		 return ResponseEntity.created(uri).build();
	}
}
