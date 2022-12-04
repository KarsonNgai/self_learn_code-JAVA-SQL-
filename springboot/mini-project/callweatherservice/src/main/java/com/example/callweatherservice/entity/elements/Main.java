package com.example.callweatherservice.entity.elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Main {
  Double temp;

  Double feels_like;

  Double temp_min;

  Double temp_max;

  int pressure;

  int humidity;

  int sea_level;

  int grnd_level;

}
