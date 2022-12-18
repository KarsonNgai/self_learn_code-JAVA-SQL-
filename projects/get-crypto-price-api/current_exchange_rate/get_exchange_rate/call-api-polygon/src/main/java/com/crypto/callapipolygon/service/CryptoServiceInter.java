package com.crypto.callapipolygon.service;

import java.util.List;
import com.crypto.callapipolygon.dto.CoinToListDto;
import com.crypto.callapipolygon.model.PreviousCloseAPI;

public interface CryptoServiceInter {
  PreviousCloseAPI getCoinInfoById(String[] coinIds);

  CoinToListDto getCoinInfoByIdInlist(String[] coinIds);
}
