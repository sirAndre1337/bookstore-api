package com.andre.bookstore.dtos;

import java.io.Serializable;

import com.andre.bookstore.domain.Category;

public class CategoryDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String description;

	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDTO(Category category) {
		super();
		id = category.getId();
		name = category.getName();
		description = category.getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
