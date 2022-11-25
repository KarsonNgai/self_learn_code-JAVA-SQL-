package com.example.bookstore_manytoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bookstore_manytoone.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
  
}
