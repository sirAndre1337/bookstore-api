package com.andre.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Campo TITULO e requirido")
	@Length(min = 3, max = 50 , message = "O campo TITULO deve ter entre 3 e 50 caracteres")
	private String title;
	
	@NotEmpty(message = "Campo AUTHOR NAME e requirido")
	@Length(min = 3, max = 50 , message = "O campo AUTHOR NAME deve ter entre 3 e 50 caracteres")
	private String name_author;
	
	@NotEmpty(message = "Campo TEXT e requirido")
	@Length(min = 10, max = 2000000 , message = "O campo TEXT deve ter entre 10 e 2.000.000 caracteres")
	private String text;

	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "category_id")
	private Category category;

	public Book() {
	}

	public Book(Long id, String title, String name_author, String text, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.name_author = name_author;
		this.text = text;
		this.category = category;
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

	public String getName_author() {
		return name_author;
	}

	public void setName_author(String name_author) {
		this.name_author = name_author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(id, other.id);
	}

}
