package com.example.testcasedemo.service.impl;

import org.springframework.stereotype.Service;
import com.example.testcasedemo.service.GreetingService;

@Service
public class GreetingServiceHolder implements GreetingService{
  public String greeting(){
    return "Hello world";
  }

  public String welcome(String name){
    return "welcome user: " + name; 
  }
}
