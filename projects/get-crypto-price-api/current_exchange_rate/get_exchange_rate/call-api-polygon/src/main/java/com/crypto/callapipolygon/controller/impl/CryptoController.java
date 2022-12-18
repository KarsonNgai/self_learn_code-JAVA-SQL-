package com.crypto.callapipolygon.controller.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crypto.callapipolygon.controller.CryptoOperation;
import com.crypto.callapipolygon.dto.CoinToListDto;
import com.crypto.callapipolygon.model.PreviousCloseAPI;
import com.crypto.callapipolygon.service.CryptoServiceInter;

@RestController
@RequestMapping("crypto/api/v1/polygon")
public class CryptoController implements CryptoOperation{

  @Autowired
  CryptoServiceInter cryptoServiceInter;

  @Override
  public PreviousCloseAPI getCoinInfoById(String[] coinIds) {
    
    return cryptoServiceInter.getCoinInfoById(coinIds);
  }

  @Override
  public CoinToListDto getCoinInfoByIdInlist(String[] coinIds) {
    
    return cryptoServiceInter.getCoinInfoByIdInlist(coinIds);
  } 
}
