package com.app.libsearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_info")
public class BookInfo {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "book_id")
  Long bookId;

  @Column(name = "author_id")
  Long authorId;

  @OneToOne(mappedBy = "bookInfo")
  @JsonIgnore
  Author author;

  @OneToOne(mappedBy = "bookInfo")
  @JsonIgnore
  Book book;
}
