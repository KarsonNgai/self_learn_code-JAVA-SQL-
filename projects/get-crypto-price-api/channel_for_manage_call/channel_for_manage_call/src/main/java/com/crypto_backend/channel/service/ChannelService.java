package com.crypto_backend.channel.service;

import java.util.List;

import com.crypto_backend.channel.dto.exchange_rate.CoinToListDto;

public interface ChannelService {

    CoinToListDto coinToUsdService(Long channelId, List<String> coinIds);
    
}
