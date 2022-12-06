package com.example.callweatherservice.service.impl;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
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

  @Autowired
  RedisTemplate<String, WeatherAPI> redisTemplate;
  

  @Override
  public WeatherAPI getAllInfo(Double lat, Double lon){

    String keyForRedis = "Weather:"+lat+":"+lon;
    
    if(redisTemplate.opsForValue().get(keyForRedis)!=null){
      return redisTemplate.opsForValue().get(keyForRedis);
    }

    System.out.println("this is key: "+keyForRedis+"|||end");
    String url = UriComponentsBuilder.fromUriString(baseUrl).
                        pathSegment(serviceVers).
                        path(serviceUrl).
                        queryParam("lat", lat).
                        queryParam("lon", lon).
                        queryParam("appid", key).
                        build().toString();
    
    
    RestTemplate restTemplate = new RestTemplate();

    WeatherAPI callWeather = restTemplate.getForObject(url, WeatherAPI.class);
  
    redisTemplate.opsForValue().set(keyForRedis, callWeather, Duration.ofMinutes(10L));
    return callWeather;
  }


  @Override
  public WeatherDTO1 getWeather(Double lat, Double lon) {
    WeatherAPI callWeather = getAllInfo(lat,lon);
    return callWeather.toWeatherDTO();
  }
}
