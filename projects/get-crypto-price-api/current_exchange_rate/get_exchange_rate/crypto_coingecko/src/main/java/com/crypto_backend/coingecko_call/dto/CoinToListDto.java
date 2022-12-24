package com.crypto_backend.coingecko_call.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Setter;


@Setter
public class CoinToListDto {
  List<ExchangeRate> exchangeRates;

  public CoinToListDto(){
    this.exchangeRates = new ArrayList<>();
  }


  public void addList(ExchangeRate exchangeRate){
    this.exchangeRates.add(exchangeRate);
  }

  public List<ExchangeRate> getExchangeRates(){
    return this.exchangeRates;
  }

}
