package com.example.bookstore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookstore.entity.Author;
import com.example.bookstore.repository.AuthorRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AuthorController {

  @Autowired
  AuthorRepository authorRepository;

  @GetMapping(value="authors")
  public List<Author> findAll(){
    return authorRepository.findAll();
  }

  @GetMapping(value="authors/id/{id}")
  public Author findById(@PathVariable(value="id") Long id){
    return authorRepository.findById(id).orElse(null);
  }

  @GetMapping(value="authors/name/{name}")
  public List<Author> findById(@PathVariable(value="name") String name){
    return authorRepository.findByName(name);
  }
}
