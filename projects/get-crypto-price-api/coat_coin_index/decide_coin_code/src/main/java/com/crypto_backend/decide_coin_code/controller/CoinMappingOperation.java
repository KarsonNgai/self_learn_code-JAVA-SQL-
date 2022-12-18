package com.crypto_backend.decide_coin_code.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crypto_backend.decide_coin_code.dto.CoinAndTransactionInfo;

public interface CoinMappingOperation {
    @GetMapping("info")
    //channels_id
    //tran id
    //coin id (self define)
    // -> url (how we contruct our api for calling third party), coin_code (for calling third party api), status
    //dto channels
    CoinAndTransactionInfo getAllWithDto(@RequestParam Long channelId, @RequestParam Long channelTransactionId, @RequestParam List<String>coinId);

    @PostMapping("coinMapping/newCoin")
    void insertNewCoin(@RequestParam Long channelId,@RequestParam String coinCode,@RequestParam String coinId,@RequestParam String coinStatus);
}
