package com.example.mylittleweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api")
public class ToThis {
  @GetMapping("/nextpage")
  public String nextPage(){
    return "t";
  }
}
