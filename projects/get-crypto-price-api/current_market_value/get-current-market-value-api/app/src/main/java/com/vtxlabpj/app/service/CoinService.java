package com.vtxlabpj.app.service;

import java.util.List;
import java.util.Map;
import com.vtxlabpj.app.dto.CoinToListDto;
import com.vtxlabpj.app.dto.CoinToUsdDto;
import com.vtxlabpj.app.model.CoinMarketAPI;
import com.vtxlabpj.app.model.CryptoExchangeRate;
import com.vtxlabpj.app.model.SimplePriceAPI;

public interface CoinService {

  /**
   * 
   * @param coinId the coin that we are looking for, empty mean every coins.
   * @param currency  default is usd.
   * @return list of the coins, max is setted in yml.
   */
  List<CoinMarketAPI> coinMarket(String coinId, String currency);

  Map<String, CryptoExchangeRate> getexchangeRate();

  /**
   * map in model SimplePriceAPI, the original version
   * @param coinIds list of coin id.
   * @param currencies list of currency.
   * @return  map;
   */
  Map<String, SimplePriceAPI> getSimplePriceExchangeRate(String[] coinIds, String[] currencies);


  /**
   * me version
   * @param coinIds list of coin id.
   * @param currencies list of currency.
   * @return map
   */
  Map<String, CoinToUsdDto> getSimplePriceExchangeRateInUsd(String[] coinIds, String[] currencies);

  /**
   * vincent way, contract
   * @param coinIds list of coin id.
   * @param currencies list of currency.
   * @return list
   */
  CoinToListDto getSimplePriceExchangeRateToListInUsd(String[] coinIds, String[] currencies);
}
