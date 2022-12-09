package com.app.libsearch.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.app.libsearch.dto.BookDto;
import com.app.libsearch.dto.OneBookDto;


public interface BookInfoOperation {
  @GetMapping(value = "/books")
  List<BookDto> getAllBook();

  @GetMapping(value = "/book")
  OneBookDto searchByName(@RequestParam String bookName);
}
