package com.app.libsearch.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.libsearch.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

  Optional<Book> findByBookName(String bookName);
}
