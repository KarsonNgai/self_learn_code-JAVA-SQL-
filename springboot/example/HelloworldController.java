package com.vtxlab.demo.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

//getMappingTrial

@Controller
@ResponseBody
//@RestController
@RequestMapping(value="/api/v1")
public class HelloworldController{

  @GetMapping(value="/login/{username}")
  public String loginAccount(@PathVariable(value="username") String username){
    return "hi "+username;
  }

  @GetMapping(value="/helloworld")
  public String helloWorld(@RequestParam(value="username",defaultValue = "World") String username) {
    return "Hello " + username;
  }
// public Map<String,Object>getController2(@RequestParam(value="id")String id, @RequestParam(value="name")String name){
  @RequestMapping(value="/thisIsNew",method=RequestMethod.GET)
  public String tryThis(){
    return "ree";
  }

  @GetMapping()
  public String defaultLayer(){ 
    return "this is default";
  }

}
