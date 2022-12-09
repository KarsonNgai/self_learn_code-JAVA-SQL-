package com.app.libsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.libsearch.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long>{
  
}
