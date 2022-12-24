package com.crypto_backend.polygon_call.dto;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRate{
  private String fromCurr;
  private String toCurr;
  private BigDecimal rate;


  public static ExchangeRate fromCoinToCurrencyInUsd(String coinName, Double oneCoinToUsdRate){
    //rate 是 1 coin對應 幾多 usd
    ExchangeRate ex = new ExchangeRate();
    ex.setFromCurr(coinName);
    ex.setToCurr("usd");
    ex.setRate(BigDecimal.valueOf(oneCoinToUsdRate));

    return ex;
  }

  public static ExchangeRate fromCurrencyToCoinInUsd(String coinName, Double oneCoinToUsdRate){
    ExchangeRate ex = new ExchangeRate();
    ex.setFromCurr("usd");
    ex.setToCurr(coinName);

    BigDecimal rate = BigDecimal.ONE.divide(BigDecimal.valueOf(oneCoinToUsdRate),new MathContext(6, RoundingMode.UP));

    ex.setRate(rate); //tbc

    return ex;
  }
}