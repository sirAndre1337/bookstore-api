package com.andre.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.andre.bookstore.domain.Category;

public class CategoryDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "Campo NOME e requirido")
	@Length(min = 3, max = 100 , message = "O campo NOME deve ter entre 3 e 100 caracteres")
	private String name;
	
	@NotEmpty(message = "Campo DESCRICAO e requirido")
	@Length(min = 3, max = 200 , message = "O campo DESCRICAO deve ter entre 3 e 200 caracteres")
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
