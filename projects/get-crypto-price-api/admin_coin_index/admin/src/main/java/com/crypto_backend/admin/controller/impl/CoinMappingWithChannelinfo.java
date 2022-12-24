package com.crypto_backend.admin.controller.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crypto_backend.admin.controller.CoinMappingOperation;
import com.crypto_backend.admin.dto.CoinAndTransactionInfo;
import com.crypto_backend.admin.entity.ChannelTransaction;
import com.crypto_backend.admin.entity.Channels;
import com.crypto_backend.admin.entity.CoinMapping;
import com.crypto_backend.admin.service.CoinMappingService;

@RestController
@RequestMapping("crypto/coincode/api/v1")
@CrossOrigin
public class CoinMappingWithChannelinfo implements CoinMappingOperation{

    @Autowired
    CoinMappingService coinMappingService;

    @Override
    public CoinAndTransactionInfo getAllWithDto(Long channelId, String domainUrl, String sourceApp, List<String> coinId) {
        Long startTime = System.nanoTime();
        CoinAndTransactionInfo returned = coinMappingService.getAllWithDto(channelId, domainUrl, sourceApp, coinId);
        Long endTime = System.nanoTime();
        System.out.println("The time is: "+(endTime- startTime)); //test if redis is worked
        return returned;
    }

    //insert in value
    @Override
    public void insertCoinMapping(Long channelId, String coinCode, String coinId, String coinStatus, UUID uuid) {
        coinMappingService.insertCoinMapping(channelId,coinCode,coinId,coinStatus, uuid);
        
    }

    @Override
    public void insertChannels(String channelCode, String channelUrl, UUID uuid) {
        coinMappingService.insertChannels(channelCode, channelUrl, uuid);
        
    }

    @Override
    public void insertChannelTransaction(Long channelId, String dominVersion, 
                                        String domainUrl, String sourceApp, 
                                        String transactionType, String transactionStatus, UUID uuid) {
        coinMappingService.insertChannelTransaction(channelId, dominVersion, domainUrl, sourceApp, 
                                                    transactionType, transactionStatus, uuid);
        
    }

    //insert in object
    @Override
    public void insertChannels(Channels channels, UUID uuid) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void insertCoinMapping(CoinMapping coinMapping, UUID uuid) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void insertChannelTransaction(ChannelTransaction channelTransaction, UUID uuid) {
        // TODO Auto-generated method stub
        
    }





    @Override
    public void insertWholeNewInfo(CoinAndTransactionInfo coinAndTransactionInfo) {
        coinMappingService.insertWholeNewInfo(coinAndTransactionInfo);
        
    }

    @Override
    public void updateWholeInfo(CoinAndTransactionInfo coinAndTransactionInfo) {
        coinMappingService.updateWholeInfo(coinAndTransactionInfo);
        
    }

    
}
