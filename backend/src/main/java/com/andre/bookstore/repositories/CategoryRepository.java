package com.andre.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.bookstore.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
