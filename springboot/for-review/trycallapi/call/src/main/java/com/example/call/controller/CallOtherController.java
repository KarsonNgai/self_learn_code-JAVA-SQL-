package com.example.call.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.call.service.CallForHelloWorld;

@RestController
@RequestMapping(value = "anotherapi")
public class CallOtherController {
  
  @Autowired
  CallForHelloWorld callForHelloWorld;

  @GetMapping(value = "call")
  public String calling(){
    return callForHelloWorld.getGreeting();
  }

  @GetMapping(value = "test")
  public String testing(){
    return "connected";
  }
}
