package com.example.callweatherservice.entity.dto;

import lombok.Data;
import java.util.Collection;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherDTO1 {
  
  Collection<Object> weather;


  public WeatherDTO1(Collection<Object> weatherOBJ){
    this.weather = weatherOBJ;
  }

  
}
