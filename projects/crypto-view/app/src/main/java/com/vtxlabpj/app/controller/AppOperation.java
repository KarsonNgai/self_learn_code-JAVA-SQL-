package com.vtxlabpj.app.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlabpj.app.dto.CoinMarketAPI;

public interface AppOperation {

  @GetMapping("coin/market")
  ResponseEntity<List<CoinMarketAPI>> coinMarket(@RequestParam(defaultValue = "") String coinId, @RequestParam(defaultValue = "usd") String currency);

  @GetMapping("coin/marketnoentity")
  List<CoinMarketAPI> sscoinMarket(@RequestParam(defaultValue = "") String coinId, @RequestParam(defaultValue = "usd") String currency);
  
}
