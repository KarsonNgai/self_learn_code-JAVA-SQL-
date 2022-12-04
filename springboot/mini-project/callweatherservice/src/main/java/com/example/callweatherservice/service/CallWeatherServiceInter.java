package com.example.callweatherservice.service;

import com.example.callweatherservice.entity.WeatherAPI;
import com.example.callweatherservice.entity.dto.WeatherDTO1;

public interface CallWeatherServiceInter {

  WeatherAPI getAllInfo(Double lat, Double lon);

  WeatherDTO1 getWeather(Double lat, Double lon);


}
