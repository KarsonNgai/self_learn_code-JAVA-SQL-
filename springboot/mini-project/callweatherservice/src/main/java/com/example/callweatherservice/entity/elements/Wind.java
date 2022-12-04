package com.example.callweatherservice.entity.elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wind {
  Double speed;

  Integer deg;

  Double gust; 

}
