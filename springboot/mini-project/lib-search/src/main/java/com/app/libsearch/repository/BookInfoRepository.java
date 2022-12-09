package com.app.libsearch.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.libsearch.entity.BookInfo;

@Repository
public interface BookInfoRepository extends JpaRepository<BookInfo,Long>{

  List<BookInfo> findByBookId(Long bookId);
  
}
