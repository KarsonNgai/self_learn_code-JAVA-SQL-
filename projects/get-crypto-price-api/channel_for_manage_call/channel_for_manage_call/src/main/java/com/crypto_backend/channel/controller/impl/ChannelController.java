package com.crypto_backend.channel.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crypto_backend.channel.controller.ChannelOperation;
import com.crypto_backend.channel.dto.exchange_rate.CoinToListDto;
import com.crypto_backend.channel.service.ChannelService;

@RestController
@RequestMapping(value = "crypto/channel/api/v1")
@CrossOrigin
public class ChannelController implements ChannelOperation{

    @Autowired
    ChannelService channelService;

    @Override
    public CoinToListDto coinToUsd(Long channelId, List<String> coinIds) {
        return channelService.coinToUsdService(channelId,coinIds);
        
    }}
