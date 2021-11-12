package com.andre.bookstore.dtos;

import java.io.Serializable;

import com.andre.bookstore.domain.Book;

public class BookDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;

	public BookDTO() {
		// TODO Auto-generated constructor stub
	}

	public BookDTO(Book book) {
		super();
		id = book.getId();
		title = book.getTitle();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
