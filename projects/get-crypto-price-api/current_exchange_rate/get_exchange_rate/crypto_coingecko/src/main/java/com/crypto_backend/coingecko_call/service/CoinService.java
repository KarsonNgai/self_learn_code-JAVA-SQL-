package com.crypto_backend.coingecko_call.service;

import java.util.List;
import java.util.Map;

import com.crypto_backend.coingecko_call.dto.CoinToListDto;
import com.crypto_backend.coingecko_call.dto.CoinToUsdDto;
import com.crypto_backend.coingecko_call.model.CoinMarketAPI;
import com.crypto_backend.coingecko_call.model.CryptoExchangeRate;
import com.crypto_backend.coingecko_call.model.SimplePriceAPI;
import com.crypto_backend.coingecko_call.problem.self_define_exception.DeserializeFailure;

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
  Map<String, SimplePriceAPI> getSimplePriceExchangeRate(String[] coinIds, String[] currencies) throws DeserializeFailure;


  /**
   * me version
   * @param coinIds list of coin id.
   * @param currencies list of currency.
   * @return map
   */
  Map<String, CoinToUsdDto> getSimplePriceExchangeRateInUsd(String[] coinIds, String[] currencies) throws DeserializeFailure;

  /**
   * vincent way, contract
   * @param coinIds list of coin id.
   * @param currencies list of currency.
   * @return list
   */
  CoinToListDto getSimplePriceExchangeRateToListInUsd(String[] coins, String[] currencies)throws DeserializeFailure;
}
