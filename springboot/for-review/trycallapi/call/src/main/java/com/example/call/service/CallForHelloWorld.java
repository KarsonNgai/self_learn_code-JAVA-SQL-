package com.example.call.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CallForHelloWorld {


  @Value("${restHello.baseUrl}")
  String baseUrl;//localhose:8080

  @Value("${restHello.serviceVers}")
  String serviceVers;//api/v1

  @Value("${restHello.serviceUrl}")
  String serviceUrl;//methodName

  
  public String getGreeting(){
    //call another service
    
    String url = UriComponentsBuilder.fromUriString(baseUrl)
                //path 同pathSegment都會整走個 "/", 但
                .pathSegment(serviceVers) //path segment中間唔會減走野 e.g. "/" ;
                .path(serviceUrl) //api/v1
                .build()
                //.encode()
                .toString();

    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(url, String.class);
    //return restTemplate.getForObject("http://localhost:8081/api/v1/hello", String.class);
  }

}
