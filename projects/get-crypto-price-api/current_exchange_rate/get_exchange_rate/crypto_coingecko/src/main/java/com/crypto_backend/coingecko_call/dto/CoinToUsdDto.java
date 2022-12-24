package com.crypto_backend.coingecko_call.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoinToUsdDto {
  private String name;

  private Double oneCoinToUSD;


}
