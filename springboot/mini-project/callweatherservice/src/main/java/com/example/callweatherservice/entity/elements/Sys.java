package com.example.callweatherservice.entity.elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sys {
  int type;
  int id;
  String country;
  Long sunrise;
  Long sunset;
}
