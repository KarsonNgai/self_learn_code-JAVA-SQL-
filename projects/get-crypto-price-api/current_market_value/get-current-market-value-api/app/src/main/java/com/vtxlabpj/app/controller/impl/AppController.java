package com.vtxlabpj.app.controller.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlabpj.app.controller.AppOperation;
import com.vtxlabpj.app.dto.CoinToListDto;
import com.vtxlabpj.app.dto.CoinToUsdDto;
import com.vtxlabpj.app.model.CoinMarketAPI;
import com.vtxlabpj.app.model.CryptoExchangeRate;
import com.vtxlabpj.app.model.SimplePriceAPI;
import com.vtxlabpj.app.service.CoinService;

@RestController
@RequestMapping(value = "crypto/api/v1/coingecko")
@CrossOrigin
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
  public Map<String, CryptoExchangeRate> getExchangeRate() {
    return coinService.getexchangeRate();
  }

  @Override
  public Map<String, SimplePriceAPI> getSimplePriceExchangeRate(String[] coinIds, String[] currencies) {

    return coinService.getSimplePriceExchangeRate(coinIds, currencies);
  }

  @Override
  public Map<String, CoinToUsdDto> getSimplePriceExchangeRateInUsd(String[] coinIds, String[] currencies) {
    
    return coinService.getSimplePriceExchangeRateInUsd(coinIds,currencies);
  }

  @Override
  public CoinToListDto getSimplePriceExchangeRateToListInUsd(String[] coinIds, String[] currencies) {

    return coinService.getSimplePriceExchangeRateToListInUsd(coinIds,currencies);
  }  
}
