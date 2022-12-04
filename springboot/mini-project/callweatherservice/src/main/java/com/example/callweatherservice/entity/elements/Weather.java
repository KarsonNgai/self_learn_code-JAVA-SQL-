package com.example.callweatherservice.entity.elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//so far useless in here
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
  Integer id;
  String main;
  String description;
  String icon;
  
}
