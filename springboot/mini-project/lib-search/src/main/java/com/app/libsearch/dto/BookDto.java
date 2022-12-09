package com.app.libsearch.dto;

import com.app.libsearch.entity.Author;
import com.app.libsearch.entity.Book;
import com.app.libsearch.entity.BookInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
  
  Book book;

  @JsonProperty(value = "author(s)")
  Author author;


  public static BookDto toDtoBookInfo(BookInfo bookInfo){
    return new BookDto(bookInfo.getBook(), bookInfo.getAuthor());
  }

}
