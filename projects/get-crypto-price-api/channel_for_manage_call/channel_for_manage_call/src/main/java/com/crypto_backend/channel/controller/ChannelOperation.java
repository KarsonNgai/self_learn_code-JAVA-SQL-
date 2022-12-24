package com.crypto_backend.channel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crypto_backend.channel.dto.exchange_rate.CoinToListDto;

public interface ChannelOperation {
    @GetMapping(value = "coin_to_usd")
    CoinToListDto coinToUsd(@RequestParam(defaultValue = "1") Long channelId, 
                    @RequestParam(defaultValue = "BTC") List<String> coinIds);
}
