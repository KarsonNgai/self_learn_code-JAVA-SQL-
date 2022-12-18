package com.crypto_backend.decide_coin_code.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crypto_backend.decide_coin_code.controller.CoinMappingOperation;
import com.crypto_backend.decide_coin_code.dto.CoinAndTransactionInfo;
import com.crypto_backend.decide_coin_code.service.CoinMappingService;

@RestController
@RequestMapping("api/v1/crypto")
public class CoinMappingWithChannelinfo implements CoinMappingOperation{

    @Autowired
    CoinMappingService coinMappingService;

    @Override
    public CoinAndTransactionInfo getAllWithDto(Long channelId, Long channelTransactionId, List<String> coinId) {
        Long startTime = System.nanoTime();
        CoinAndTransactionInfo returned = coinMappingService.getAllWithDto(channelId, channelTransactionId, coinId);
        Long endTime = System.nanoTime();
        System.out.println("The time is: "+(endTime- startTime)); //test if redis is worked
        return returned;
    }

    @Override
    public void insertNewCoin(Long channelId, String coinCode, String coinId, String coinStatus) {
        coinMappingService.insertNewCoin(channelId,coinCode,coinId,coinStatus);
     
        
    }
    
}
