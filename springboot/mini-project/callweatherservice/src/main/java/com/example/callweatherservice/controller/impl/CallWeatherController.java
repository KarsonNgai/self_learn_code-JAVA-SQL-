package com.example.callweatherservice.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.callweatherservice.controller.CallWeatherControllerInter;
import com.example.callweatherservice.entity.WeatherAPI;
import com.example.callweatherservice.entity.dto.WeatherDTO1;
import com.example.callweatherservice.service.CallWeatherServiceInter;

//link of api: https://openweathermap.org/current
//要set野去check個時間
@RestController
@RequestMapping(value="api/call")
public class CallWeatherController implements CallWeatherControllerInter{

  @Autowired
  CallWeatherServiceInter callWeatherService;

  @Override
  public WeatherAPI getAllInfo(Double lat, Double lon) {
    return callWeatherService.getAllInfo(lat, lon);
  }

  @Override
  public WeatherDTO1 getWeather(Double lat, Double lon) {
    return callWeatherService.getWeather(lat, lon);
    
  }



}
