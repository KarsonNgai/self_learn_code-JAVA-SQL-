package com.example.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="books")
@NoArgsConstructor
@Data
public class Book {
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  @Column(name = "book_id")
  Long id;

  @Column(name = "book_name")
  String name;

  @Column(name = "author_id")
  Long authorId;
  

}
