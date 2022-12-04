package com.example.callweatherservice.entity.elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Coord {
  //BigDecimal
  Double lon;
  Double lat;
}
