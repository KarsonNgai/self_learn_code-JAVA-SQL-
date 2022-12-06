package com.example.callweatherservice.entity.elements;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Coord implements Serializable{
  //BigDecimal
  Double lon;
  Double lat;
}
