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

@Data
@Entity
@Table(name = "author")
@NoArgsConstructor
@AllArgsConstructor
public class Author {
  @Id
  @Column(name = "author_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long authorId;

  @Column(name = "author_name")
  String authorName;

  @OneToOne
  @JoinColumn(name = "author_id", referencedColumnName = "author_id")
  @JsonIgnore
  BookInfo bookInfo;
}
