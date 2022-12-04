package com.example.testcasedemo.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.testcasedemo.controller.GreetingOperation;
import com.example.testcasedemo.service.GreetingService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1")
@AllArgsConstructor
public class GreetingController implements GreetingOperation{

  @Autowired
  GreetingService greetingService;

  @Override
  public String greeting() {
    return greetingService.greeting();
  }

  @Override
  public ResponseEntity<String> welcome(String name){
    return ResponseEntity.ok().body(greetingService.welcome(name));
  }
  
}
