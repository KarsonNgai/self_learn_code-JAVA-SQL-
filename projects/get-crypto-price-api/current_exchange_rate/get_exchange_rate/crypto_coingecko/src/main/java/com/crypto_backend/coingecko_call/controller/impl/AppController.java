package com.crypto_backend.coingecko_call.controller.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crypto_backend.coingecko_call.controller.AppOperation;
import com.crypto_backend.coingecko_call.dto.CoinToListDto;
import com.crypto_backend.coingecko_call.dto.CoinToUsdDto;
import com.crypto_backend.coingecko_call.model.CoinMarketAPI;
import com.crypto_backend.coingecko_call.model.CryptoExchangeRate;
import com.crypto_backend.coingecko_call.model.SimplePriceAPI;
import com.crypto_backend.coingecko_call.response.ApiResponse;
import com.crypto_backend.coingecko_call.service.CoinService;

@RestController
@RequestMapping(value = "crypto/coingecko/api/v1")
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
  public ResponseEntity<ApiResponse<CoinToListDto>> getSimplePriceExchangeRateToListInUsd(String[] coins, String[] currencies) {

    CoinToListDto returned = coinService.getSimplePriceExchangeRateToListInUsd(coins,currencies);
    return ResponseEntity.ok().body(new ApiResponse<>(returned));
  }  
}
