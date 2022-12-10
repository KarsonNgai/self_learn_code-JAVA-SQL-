package com.app.libsearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy;

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

  @ManyToOne  //(fetch = FetchType.LAZY) //lasy會有問題
  @JoinColumn(name = "book_id", insertable = false,updatable = false)
  @JsonIgnore
  Author author;

  @ManyToOne //(fetch = FetchType.LAZY)
  @JsonIgnore
  @JoinColumn(name = "book_id", insertable = false, updatable = false)
  Book book;
}
