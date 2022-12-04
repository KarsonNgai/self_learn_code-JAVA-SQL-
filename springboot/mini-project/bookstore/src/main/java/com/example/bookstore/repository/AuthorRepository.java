package com.example.bookstore.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bookstore.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long>{
  List<Author>findByName(String name);

  List<Author>findByNameContaining(String name);
}
