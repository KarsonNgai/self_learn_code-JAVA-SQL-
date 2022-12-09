package com.app.libsearch.service;

import java.util.List;
import com.app.libsearch.dto.BookDto;
import com.app.libsearch.dto.OneBookDto;

public interface BookInfoServiceInter {
  
  List<BookDto> getAllBook();

  OneBookDto searchByName(String bookName);

  String getBooksForHTML();
}
