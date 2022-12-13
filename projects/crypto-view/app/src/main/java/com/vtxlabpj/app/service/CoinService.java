package com.vtxlabpj.app.service;

import java.util.List;
import com.vtxlabpj.app.dto.CoinMarketAPI;

public interface CoinService {

  List<CoinMarketAPI> coinMarket(String coinId, String currency);

}
