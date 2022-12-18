package com.crypto.callapipolygon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.crypto.callapipolygon.dto.CoinToListDto;
import com.crypto.callapipolygon.model.PreviousCloseAPI;

public interface CryptoOperation {
  
  @GetMapping("previous_back")
  //PreviousCloseAPI getCoinInfoById();
  PreviousCloseAPI getCoinInfoById(@RequestParam(defaultValue = "X:BTCUSD") String[] coinIds);

  @GetMapping("previous_back/list")
  CoinToListDto getCoinInfoByIdInlist(@RequestParam(defaultValue = "X:BTCUSD") String[] coinIds);
}
