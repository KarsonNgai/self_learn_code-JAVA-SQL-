package com.app.libsearch.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.libsearch.dto.BookDto;
import com.app.libsearch.entity.Author;
import com.app.libsearch.entity.Book;
import com.app.libsearch.entity.BookInfo;
import com.app.libsearch.repository.AuthorRepository;
import com.app.libsearch.repository.BookInfoRepository;
import com.app.libsearch.repository.BookRepository;

@RestController
@RequestMapping(value = "demo")
public class MyController {

  @Autowired
  AuthorRepository authorRepository;

  @Autowired
  BookRepository bookRepository;

  @Autowired
  BookInfoRepository bookInfoRepository;

  @GetMapping(value = "authors")
  public List<Author> getAllAuthor(){
    return authorRepository.findAll();
  }

  @GetMapping(value = "test")
  public Author testing(){
    List<BookInfo> bookInfos = bookInfoRepository.findAll();
    List<BookDto> bookdto = new ArrayList<>();

    

    return bookInfos.get(0).getAuthor();
  }

  /*
   *     List<BookInfo> bookInfos = bookInfoRepository.findAll();
    List<BookDto> bookdto = new ArrayList<>();
    for(int i=0;i<bookInfos.size();i++){
      Long authorId = bookInfos.get(i).getAuthorId();
      Long bookId = bookInfos.get(i).getBookId();
      Author author = authorRepository.findById(authorId).get();
      Book book = bookRepository.findById(bookId).get();
      bookdto.add(new BookDto(book, author));
    }

    return bookdto;
   */

   
}
