package com.app.libsearch.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.libsearch.dto.BookDto;
import com.app.libsearch.dto.OneBookDto;
import com.app.libsearch.entity.Author;
import com.app.libsearch.entity.Book;
import com.app.libsearch.entity.BookInfo;
import com.app.libsearch.repository.AuthorRepository;
import com.app.libsearch.repository.BookInfoRepository;
import com.app.libsearch.repository.BookRepository;
import com.app.libsearch.service.BookInfoServiceInter;

@Service
public class BookInfoService implements BookInfoServiceInter{

  @Autowired
  BookRepository bookRepository;

  @Autowired
  BookInfoRepository bookInfoRepository;

  @Autowired
  AuthorRepository authorRepository;

  @Override
  public List<BookDto> getAllBook() {
    List<BookInfo> bookInfos = bookInfoRepository.findAll();
    List<BookDto> bookdto = new ArrayList<>();
    for(int i=0;i<bookInfos.size();i++){
      Long authorId = bookInfos.get(i).getAuthorId();
      Long bookId = bookInfos.get(i).getBookId();
      Author author = authorRepository.findById(authorId).get();
      Book book = bookRepository.findById(bookId).get();
      bookdto.add(new BookDto(book, author));
    }

    return bookdto;
    
  }

  @Override
  public OneBookDto searchByName(String bookName) {
    Long bookId = bookRepository.findByBookName(bookName).orElse(new Book()).getBookId();
    if(Objects.isNull(bookId)) return new OneBookDto();
    List<BookInfo> x =  bookInfoRepository.findByBookId(bookId);
    return OneBookDto.toDtoBookInfos(x); 
  }

  @Override
  public String getBooksForHTML(){
    StringBuilder returnThis = new StringBuilder();
    List<Book> books = bookRepository.findAll();
    for(Book bk :books){
      returnThis.append(bk.getBookId());
      returnThis.append(" : ");
      returnThis.append(bk.getBookName());
      returnThis.append("||  ");
    }
    
    return returnThis.toString();
  }
  
  
}
