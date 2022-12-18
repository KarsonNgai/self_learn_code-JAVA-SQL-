package com.crypto_backend.decide_coin_code.service;

import java.util.List;

import com.crypto_backend.decide_coin_code.dto.CoinAndTransactionInfo;

public interface CoinMappingService {

	CoinAndTransactionInfo getAllWithDto(Long channelId, Long channelTransactionId, List<String> coinId);

    void insertNewCoin(Long channelId, String coinCode, String coinId, String coinStatus);
    
}
