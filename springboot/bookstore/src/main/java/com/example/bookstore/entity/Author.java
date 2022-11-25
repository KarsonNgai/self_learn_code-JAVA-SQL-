package com.example.bookstore.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="authors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "author_id")
  Long id;

  @Column(name = "author_name")
  String name;

  
  @OneToMany(fetch = FetchType.LAZY,//default: lazy
    cascade = CascadeType.PERSIST, orphanRemoval = true) //mappedBy = "author_id",
  @JoinColumn(name = "author_id")
  private List<Book> books= new ArrayList<>();

  public Author(Long id, String name){
    this.id= id;
    this.name=name;
  }
}
