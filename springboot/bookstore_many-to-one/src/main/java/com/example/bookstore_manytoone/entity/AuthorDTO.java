package com.example.bookstore_manytoone.entity;

import java.util.List;
import lombok.Data;

@Data
public class AuthorDTO {

  Long id;


  String name;

  List<Book> books;

  public AuthorDTO(Long id, String name){
    this.id=id;
    this.name=name;
  }

  public AuthorDTO(Long id,String name, List<Book> books){
    this.id=id;
    this.name=name;
    this.books=books;
  }


}
