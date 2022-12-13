package com.vtxlabpj.app.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlabpj.app.controller.AppOperation;
import com.vtxlabpj.app.dto.CoinMarketAPI;
import com.vtxlabpj.app.service.CoinService;

@RestController
@RequestMapping(value = "crypto/api/v1")
@CrossOrigin(origins = "http://localhost:8080")
//CORS(Cross origin resource sharing)
//link: https://stackoverflow.com/questions/65895332/react-and-axios-axios-cant-access-java-springboot-rest-backend-service-becaus
public class AppController implements AppOperation{

  @Autowired
  CoinService coinService;
  
  @Override
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<List<CoinMarketAPI>> coinMarket(String coinId, String currency){

    List<CoinMarketAPI> coinMarketAPIs= coinService.coinMarket(coinId, currency);

    return ResponseEntity.ok().body(coinMarketAPIs);
  }  

  @Override
  @ResponseStatus(value = HttpStatus.OK)
  public List<CoinMarketAPI> sscoinMarket(String coinId, String currency){
    List<CoinMarketAPI> coinMarketAPIs= coinService.coinMarket(coinId, currency);
    return coinMarketAPIs;
  }  
}
