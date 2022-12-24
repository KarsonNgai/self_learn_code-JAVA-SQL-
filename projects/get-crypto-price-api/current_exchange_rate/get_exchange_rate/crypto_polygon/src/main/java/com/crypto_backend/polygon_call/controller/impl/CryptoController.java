package com.crypto_backend.polygon_call.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crypto_backend.polygon_call.controller.CryptoOperation;
import com.crypto_backend.polygon_call.dto.CoinToListDto;
import com.crypto_backend.polygon_call.model.PreviousCloseAPI;
import com.crypto_backend.polygon_call.service.CryptoServiceInter;

@RestController
@RequestMapping("crypto/polygon/api/v1")
public class CryptoController implements CryptoOperation{

  @Autowired
  CryptoServiceInter cryptoServiceInter;

  @Override
  public PreviousCloseAPI getCoinInfoById(String[] coinIds) {
    
    return cryptoServiceInter.getCoinInfoById(coinIds);
  }

  @Override
  public CoinToListDto getCoinInfoByIdInlist(List<String> coins) {
    
    return cryptoServiceInter.getCoinInfoByIdInlist(coins);
  } 
}
