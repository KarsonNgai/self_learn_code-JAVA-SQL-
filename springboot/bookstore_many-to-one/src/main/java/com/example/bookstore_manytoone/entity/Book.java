package com.example.bookstore_manytoone.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="books")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  @Column(name = "book_id")
  Long id;

  @Column(name = "book_name")
  String name;

  @JsonIgnore
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "author_id")
  Author author;

  public BookDTO toDTO(){
    return new BookDTO(this.id, this.name);
  }

  public BookDTO toDTOWithAuthor(){
    return new BookDTO(this.id, this.name, this.author);
  }
  

}
