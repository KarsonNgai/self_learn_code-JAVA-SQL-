package com.crypto_backend.polygon_call.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crypto_backend.polygon_call.dto.CoinToListDto;
import com.crypto_backend.polygon_call.model.PreviousCloseAPI;

public interface CryptoOperation {
  
  /**
   * call api and get with model
   * @param coinIds
   * @return
   */
  @GetMapping("previous_back")
  PreviousCloseAPI getCoinInfoById(@RequestParam(defaultValue = "X:BTCUSD") String[] coinIds);

  @GetMapping("simple-price")
  CoinToListDto getCoinInfoByIdInlist(@RequestParam(defaultValue = "BTC") List<String> coins);
}
