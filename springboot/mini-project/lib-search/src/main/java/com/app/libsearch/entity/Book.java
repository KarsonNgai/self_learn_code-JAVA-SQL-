package com.app.libsearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
  @Id
  @Column(name = "book_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long bookId;

  @Column(name = "book_name")
  String bookName;

  @Column(name = "book_discr")
  String bookDiscribe;

  @Column(name = "public_date")
  String publicDate;

  //see Authors
  @OneToOne
  @JoinColumn(name = "book_id", referencedColumnName = "book_id")
  @JsonIgnore
  BookInfo bookInfo;
}
