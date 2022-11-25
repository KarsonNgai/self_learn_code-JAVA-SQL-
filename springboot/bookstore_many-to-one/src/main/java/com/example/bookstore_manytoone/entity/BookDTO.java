package com.example.bookstore_manytoone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BookDTO {
  Long id;

  String name;

  Author authors;

  public BookDTO(Long id, String name){
    this.id = id;
    this.name = name;
  }
}
