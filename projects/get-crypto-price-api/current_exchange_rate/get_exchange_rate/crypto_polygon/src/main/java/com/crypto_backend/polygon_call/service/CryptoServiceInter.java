package com.crypto_backend.polygon_call.service;

import java.util.List;

import com.crypto_backend.polygon_call.dto.CoinToListDto;
import com.crypto_backend.polygon_call.model.PreviousCloseAPI;

public interface CryptoServiceInter {
  PreviousCloseAPI getCoinInfoById(String[] coinIds);

  CoinToListDto getCoinInfoByIdInlist(List<String> coins);
}
