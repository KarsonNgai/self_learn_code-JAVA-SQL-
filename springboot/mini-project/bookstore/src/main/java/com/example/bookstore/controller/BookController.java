package com.example.bookstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.repository.BookRepository;

//@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class BookController {
  @Autowired
  BookRepository bookRepository;

  @Autowired
  AuthorRepository authorRepository;

  @GetMapping(value="del")
  public List<Book> deldel(){
    return bookRepository.findAll();
  }

  @GetMapping(value="/author/{id}/books")
  public ResponseEntity<List<Book>> getAllBookByAuthorId(@PathVariable(value="id") Long id){
    Author authors = authorRepository.findById(id).orElseThrow(()-> new NullPointerException("Not found Tutorial with id = " + id));
    List<Book> books = new ArrayList<>();
    books.addAll(authors.getBooks());

    return ResponseEntity.ok().body(books);
  }

  @GetMapping(value="/author/books")
  public ResponseEntity<Author> getAllWithAuthor(){
    List<Author> authors = authorRepository.findAll();
    Author oneAuthor = authors.get(0);

    return ResponseEntity.ok().body(oneAuthor);
  }

  @PostMapping("/author/{authorId}/book")
  public ResponseEntity<List<Book>> createBook(@PathVariable Long authorId){
      //@RequestBody Book bookRequest) {
    //Book books = authorRepository.findById(authorId).map(tutorial -> {
      //tutorial.getBooks().add(bookRequest);
      //return bookRepository.save(bookRequest);
    //}).orElseThrow(() -> new NullPointerException("Not found Tutorial with id = " + authorId));
    Book books = new Book();
    books.setAuthorId(authorId);
    books.setName("new book in vscode");

    List<Book> booksShow; 
    try{
      booksShow = authorRepository.findById(authorId).get().getBooks(); //select
    }catch(NoSuchElementException e){
      return ResponseEntity.badRequest().body(null);
    }
    booksShow.add(books);
    bookRepository.save(books);
    return ResponseEntity.ok().body(booksShow);
  }

  @PostMapping("postauthor/{id}/{name}")
  public ResponseEntity<Long> createAuthor(@PathVariable Long id, @PathVariable String name){
    Author authors = new Author();
    //authors.setId(id);
    authors.setName(name);
    authorRepository.save(authors);
    return ResponseEntity.ok().body(12L);
  }
}
