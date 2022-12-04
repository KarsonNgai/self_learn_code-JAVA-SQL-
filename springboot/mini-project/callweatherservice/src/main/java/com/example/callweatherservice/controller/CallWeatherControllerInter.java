package com.example.callweatherservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.callweatherservice.entity.WeatherAPI;
import com.example.callweatherservice.entity.dto.WeatherDTO1;

public interface CallWeatherControllerInter {
  
  @GetMapping(value = "weathers")
  public WeatherAPI getAllInfo(@RequestParam Double lat, @RequestParam Double lon);

  @GetMapping(value = "weatherOnly")
  public WeatherDTO1 getWeather(@RequestParam Double lat, @RequestParam Double lon);
}
