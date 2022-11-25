package com.example.bookstore_manytoone.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

  
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "author")
  //mappedBy 係map book入面既author既variable_name, case sensitive
    //fetchType is default by lazy
  //@JoinColumn(name = "author_id")
  @JsonIgnore
  List<Book> books= new ArrayList<>();

  public AuthorDTO toDTO(){
    return new AuthorDTO(this.getId(),this.getName());
  }
  //有@JsonIgnore,可以唔洗用DTO去exclude books;
  //this method Or @JsonIgnore, 用左JsonIgnore,拎出黎既book係null

  public AuthorDTO toDTOWithBook(){
    return new AuthorDTO(this.getId(),this.getName(),this.getBooks());
  }
}
