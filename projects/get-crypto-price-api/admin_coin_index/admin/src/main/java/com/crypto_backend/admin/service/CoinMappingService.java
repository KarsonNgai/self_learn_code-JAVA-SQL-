package com.crypto_backend.admin.service;

import java.util.List;
import java.util.UUID;

import com.crypto_backend.admin.dto.CoinAndTransactionInfo;

public interface CoinMappingService {

	CoinAndTransactionInfo getAllWithDto(Long channelId, String domainUrl, String sourceApp, List<String> coinId);

    // insert with value
    void insertChannels(String channelCode, String channelUrl, UUID uuid);
    
    void insertCoinMapping(Long channelId, String coinCode, String coinId, String coinStatus, UUID uuid);
    
    
    void insertChannelTransaction(Long channelId, String dominVersion, String domainUrl, 
                                    String sourceApp, String transactionType, 
                                    String transactionStatus, UUID uuid);
    
    void insertWholeNewInfo(CoinAndTransactionInfo coinAndTransactionInfo);


    void updateWholeInfo(CoinAndTransactionInfo coinAndTransactionInfo);

}
