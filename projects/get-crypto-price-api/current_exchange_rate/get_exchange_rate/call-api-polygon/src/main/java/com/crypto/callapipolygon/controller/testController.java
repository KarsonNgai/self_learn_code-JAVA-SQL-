package com.crypto.callapipolygon.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.crypto.callapipolygon.api_utility.API_URI;
import com.crypto.callapipolygon.model.PreviousCloseAPI;

@RestController
@RequestMapping(value = "demo")
public class testController {

  @Autowired
  API_URI api;
  
  @GetMapping(value = "pb")
  public List<String> getALL(String[] x){
    List<String> y=new ArrayList<>();
    for(int i=0;i<x.length;i++){
      y.add(x[i]);
    }
    return y;
  }
}
