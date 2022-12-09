package com.app.libsearch.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.libsearch.controller.BookInfoOperation;
import com.app.libsearch.dto.BookDto;
import com.app.libsearch.dto.OneBookDto;
import com.app.libsearch.service.BookInfoServiceInter;

@RestController
@RequestMapping(value = "api/v1")
public class BookInfoController implements BookInfoOperation{

  @Autowired
  BookInfoServiceInter bookInfoServiceInter;


  @Override
  public List<BookDto> getAllBook() {
    return bookInfoServiceInter.getAllBook();
  }


  @Override
  public OneBookDto searchByName(String bookName) {
    return bookInfoServiceInter.searchByName(bookName);
  }
  
}
