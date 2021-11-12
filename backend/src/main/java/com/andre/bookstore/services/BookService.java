package com.andre.bookstore.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.bookstore.domain.Book;
import com.andre.bookstore.dtos.BookDTO;
import com.andre.bookstore.repositories.BookRepository;
import com.andre.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private CategoryService categoryService;

	public Book findById(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		return book.orElseThrow(() -> new ObjectNotFoundException("Book not found by id : " + id));
	}

	public List<BookDTO> findAll(Long id_category) {
		categoryService.findById(id_category);
		List<Book> list = bookRepository.findAllByCategory(id_category);
		return list.stream().map((x) -> new BookDTO(x)).collect(Collectors.toList());
	}

	public Book update(Long id, Book book) {
		Book newBook = findById(id);
		updateData(newBook, book);
		return bookRepository.save(newBook);
	}

	private void updateData(Book newBook, Book book) {
		newBook.setName_author(book.getName_author());
		newBook.setTitle(book.getTitle());
		newBook.setText(book.getText());
	}
}
