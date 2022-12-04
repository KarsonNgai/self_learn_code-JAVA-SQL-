package com.example.callweatherservice.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.callweatherservice.entity.WeatherAPI;
import com.example.callweatherservice.entity.dto.WeatherDTO1;
import com.example.callweatherservice.service.CallWeatherServiceInter;

@Service
public class CallWeatherService implements CallWeatherServiceInter{

  @Value("${weatherAPI.baseUrl}")
  String baseUrl;

  @Value("${weatherAPI.serviceVers}")
  String serviceVers;

  @Value("${weatherAPI.serviceUrl}")
  String serviceUrl;

  @Value("${weatherAPI.key}")
  String key;
  

  @Override
  public WeatherAPI getAllInfo(Double lat, Double lon){
    String url = UriComponentsBuilder.fromUriString(baseUrl).
                        pathSegment(serviceVers).
                        path(serviceUrl).
                        queryParam("lat", lat).
                        queryParam("lon", lon).
                        queryParam("appid", key).
                        build().toString();
    
    
    RestTemplate restTemplate = new RestTemplate();

    WeatherAPI callWeather = restTemplate.getForObject(url, WeatherAPI.class);
  
    return callWeather;
  }


  @Override
  public WeatherDTO1 getWeather(Double lat, Double lon) {
    WeatherAPI callWeather = getAllInfo(lat,lon);
    return callWeather.toWeatherDTO();
  }
}
