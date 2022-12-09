package com.app.libsearch.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ShowHTMLOperation {
  @GetMapping()
  String home();

  @GetMapping(value = "/bookList")
  String showAllBooks(Model model);

  @GetMapping(value = "/search")
  String searchByName(@RequestParam String bookName, Model model);

}
