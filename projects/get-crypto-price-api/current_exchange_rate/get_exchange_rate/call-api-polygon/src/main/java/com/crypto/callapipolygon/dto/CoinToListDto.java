package com.crypto.callapipolygon.dto;


import java.util.ArrayList;
import java.util.List;
import lombok.Setter;


@Setter
public class CoinToListDto {
  List<ExchangeRate> exchangeRates;

  public CoinToListDto(){
    this.exchangeRates = new ArrayList<>();
  }


  public static void convertToDtoAndAddInList(String id, Double rate, CoinToListDto coinToListDto) {
    coinToListDto.addList(ExchangeRate.fromCoinToCurrencyInUsd(id, rate));
    coinToListDto.addList(ExchangeRate.fromCurrencyToCoinInUsd(id, rate));

    //可以唔要coinToListDto
    //用this.exchangeRates.addList就得
  }

  public void addList(ExchangeRate exchangeRate){
    this.exchangeRates.add(exchangeRate);
  }

  public List<ExchangeRate> getExchangeRates(){
    return this.exchangeRates;
  }

}
