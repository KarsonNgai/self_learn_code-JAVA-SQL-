package com.app.libsearch.controller.impl;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.app.libsearch.controller.ShowHTMLOperation;
import com.app.libsearch.dto.OneBookDto;
import com.app.libsearch.service.BookInfoServiceInter;

@Controller
@RequestMapping(value = "api/v1h")
public class ShowHTML implements ShowHTMLOperation{

  @Autowired
  BookInfoServiceInter bookInfoServiceInter;
  
  @Override
  public String home(){
    return "home.html";
  }

  @Override
  public String showAllBooks(Model model){
    String books= bookInfoServiceInter.getBooksForHTML();
    model.addAttribute("bookName", books);
    return "book_list.html";
  }

  @Override
  public String searchByName(@RequestParam String bookName, Model model){
    OneBookDto bookinfo=bookInfoServiceInter.searchByName(bookName);
    if(Objects.isNull(bookinfo.getBook())) return "book_not_found.html";
    model.addAttribute("bookId", bookinfo.getBook().getBookId());
    model.addAttribute("bookName", bookinfo.getBook().getBookName());
    model.addAttribute("bookDiscribe", bookinfo.getBook().getBookDiscribe());
    model.addAttribute("publicDate", bookinfo.getBook().getPublicDate());
    model.addAttribute("authorName", bookinfo.getAuthors());
    return "show_book.html";
  }



}


