package com.example.bookstore_manytoone.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookstore_manytoone.entity.Author;
import com.example.bookstore_manytoone.entity.AuthorDTO;
import com.example.bookstore_manytoone.entity.Book;
import com.example.bookstore_manytoone.entity.BookDTO;
import com.example.bookstore_manytoone.repository.AuthorRepository;
import com.example.bookstore_manytoone.repository.BookRepository;

@RestController
@RequestMapping("/api")
public class ABConroller {
  @Autowired
  AuthorRepository authorRepository;

  @Autowired
  BookRepository bookRepository;

  @GetMapping("/authors")
  public ResponseEntity<List<AuthorDTO>> getAllAuthor(){
    List<Author> author = authorRepository.findAll();
    List<AuthorDTO> authorDTO = new ArrayList<>();
    //for loop去用authorDTO去add番, response會係dto
    for(Author a:author){
      AuthorDTO tempAuthor= a.toDTO();
      //tempAuthor.setBooks(a.getBooks());
      authorDTO.add(tempAuthor);
    }

    //Another way to write
    //author.forEach(e->authorDTO.add(e.toDTO()));
    return ResponseEntity.ok().body(authorDTO);
    //return ResponseEntity.ok().body(author);
  }

  @GetMapping("/authorsWithBooks")
  public ResponseEntity<List<AuthorDTO>> getAll(){
    List<Author> author = authorRepository.findAll();
    List<AuthorDTO> authorDTO = new ArrayList<>();
    //for loop去用authorDTO去add番, response會係dto
    for(Author a:author){
      authorDTO.add(a.toDTOWithBook());
    }
    return ResponseEntity.ok().body(authorDTO);
    //return ResponseEntity.ok().body(author);
  }

  //problem, 做唔到,佢會loop一次
  @GetMapping("/booksWithAuthors")
  public ResponseEntity<List<BookDTO>> getAll2(){
    List<Book> books = bookRepository.findAll();
    List<BookDTO> bookDTOs = new ArrayList<>();
    //for loop去用authorDTO去add番, response會係dto
    for(Book a:books){
      bookDTOs.add(a.toDTOWithAuthor());
    }
    return ResponseEntity.ok().body(bookDTOs);
    //return ResponseEntity.ok().body(books);
  }

  @GetMapping("/books")
  public ResponseEntity<List<Book>> getAllBook(){
    return ResponseEntity.ok().body(bookRepository.findAll());
  }
  //同上面一樣,但用@JsonIgnore 好方便 

  @GetMapping("/book/authorid/{id}")
  public ResponseEntity<List<Book>> findBookByAuthorId(@PathVariable(value="id") Long id){
    Author authors = authorRepository.findById(id).orElse(new Author());
    List<Book> books = authors.getBooks();
    if(books.isEmpty()){
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok().body(books);
  }

  @DeleteMapping(value="/author/authorId/{id}")
  public ResponseEntity<Void> deleteBookByAuthorId(@PathVariable(value="id") Long id){
    List<Book> books= bookRepository.findAll(); 
    // another way to find book by id,
    //上面既做法係先用author去findbyid,再出list,
    //今個做法係先出book list,再對author_id, In sql(authors.pk == books.fk)
    //應該上面好D
    //P.s. 如果正常寫,應有service 既findById,到時call method而唔會再寫過
    for(Book x: books){
      if(x.getAuthor().getId().equals(id)){
        bookRepository.delete(x);
      }
    }
    return ResponseEntity.noContent().build();
  }
}
