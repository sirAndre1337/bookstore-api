package com.andre.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andre.bookstore.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	@Query("SELECT b FROM Book b where b.category.id = :id_category ORDER BY title")
	List<Book> findAllByCategory(@Param(value = "id_category") Long id_category);

}
