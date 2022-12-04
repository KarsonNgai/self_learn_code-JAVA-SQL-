package com.example.mylittleweb.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
  @GetMapping(value="/greeting")
  public String greeting(@RequestParam(name="name",required=false,defaultValue = "Guest") String name, Model model){
    model.addAttribute("name",name); 
    return "greetings.html";
  }

  @GetMapping(value="/greeting/map")
  public String greeting2(@RequestBody Map<String,Object> obj){
    obj.put("name","poppy");
    return "greetings.html";
  }
}
