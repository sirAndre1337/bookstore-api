package com.andre.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.bookstore.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
