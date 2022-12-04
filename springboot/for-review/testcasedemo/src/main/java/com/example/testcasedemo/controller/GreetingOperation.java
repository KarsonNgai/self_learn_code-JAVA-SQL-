package com.example.testcasedemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface GreetingOperation {
  @GetMapping(value = "/greeting")
  String greeting();

  @GetMapping(value = "/user")
  ResponseEntity<String> welcome(@RequestParam (value = "name") String name);
}


