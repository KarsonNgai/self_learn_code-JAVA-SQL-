package com.example.callweatherservice.entity;

import java.util.Collection;
import com.example.callweatherservice.entity.dto.WeatherDTO1;
import com.example.callweatherservice.entity.elements.Cloud;
import com.example.callweatherservice.entity.elements.Coord;
import com.example.callweatherservice.entity.elements.Main;
import com.example.callweatherservice.entity.elements.Rain;
import com.example.callweatherservice.entity.elements.Sys;
import com.example.callweatherservice.entity.elements.Wind;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherAPI {
  
  Coord coord;

  @JsonProperty
  Collection<Object> weather;
  
  String base;
  
  Main main;

  Integer visibility;

  Wind wind;
  
  Cloud clouds;

  @JsonProperty//不影響
  Rain rain;


  Long dt;

  Sys sys;

  Integer timezone;

  Integer id;

  String name;

  Integer cod;


  public WeatherDTO1 toWeatherDTO(){
    return new WeatherDTO1(weather);
  }
}

