package com.app.libsearch.dto;

import java.util.ArrayList;
import java.util.List;
import com.app.libsearch.entity.Book;
import com.app.libsearch.entity.BookInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OneBookDto {
  Book book;

  List<String> authors;


  public static OneBookDto toDtoBookInfos(List<BookInfo> bookInfo){
    Book tempBook= bookInfo.get(0).getBook();

    List<String> authors = new ArrayList<>();
    for(BookInfo i: bookInfo){
      if(i.getAuthor()!=null){
        authors.add(i.getAuthor().getAuthorName());
      }
    }
    return new OneBookDto(tempBook, authors);
  }

  
}
