package com.crypto_backend.decide_coin_code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crypto_backend.decide_coin_code.entity.ChannelTransaction;
import com.crypto_backend.decide_coin_code.entity.Channels;
import com.crypto_backend.decide_coin_code.entity.CoinMapping;
import com.crypto_backend.decide_coin_code.repository.ChannelTransactionRepository;
import com.crypto_backend.decide_coin_code.repository.ChannelsRepository;
import com.crypto_backend.decide_coin_code.repository.CoinMappingRepository;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("fortest")
public class testController {

    @Autowired
    ChannelsRepository channelsRepository;

    @Autowired
    ChannelTransactionRepository channelTransactionRepository;

    @Autowired
    CoinMappingRepository coinMappingRepository;

    @GetMapping("channels")
    List<Channels> getChannels(){
        return channelsRepository.findAll();
    }

    @GetMapping(value="ct")
    List<ChannelTransaction> getCT(){
        return channelTransactionRepository.findAll();
    }
    
    @GetMapping(value = "coinMapping")
    List<CoinMapping> getcoin(){
        return coinMappingRepository.findAll();
    }

    @GetMapping(value = "coinMapping/demo")
    List<CoinMapping> getcoinww(@RequestParam(defaultValue = "BTC") List<String> x){
       // return coinMappingRepository.findByCoinIdIn(x);
        //return coinMappingRepository.findByCoinIdAndChannelId("BTC", 1L);
        return coinMappingRepository.findByCoinIdInAndChannelId(x,99L);
    }

    


    


    
    
}
