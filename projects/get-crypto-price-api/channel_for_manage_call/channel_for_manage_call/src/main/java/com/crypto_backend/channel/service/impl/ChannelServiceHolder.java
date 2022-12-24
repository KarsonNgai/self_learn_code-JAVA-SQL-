package com.crypto_backend.channel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crypto_backend.channel.api_uility.CoinMappingApiUrl;
import com.crypto_backend.channel.api_uility.MethodURL;
import com.crypto_backend.channel.dto.coinmapping_url.CoinAndTransactionInfo;
import com.crypto_backend.channel.dto.exchange_rate.CoinToListDto;
import com.crypto_backend.channel.service.ChannelService;

@Service
public class ChannelServiceHolder implements ChannelService{

    @Autowired
    CoinMappingApiUrl coinMappingApiUrl;

    @Autowired
    MethodURL methodURL;

    private CoinAndTransactionInfo callToCoinMapping(Long channelId, List<String> coinId){
        String coinMappingUrl = coinMappingApiUrl.getCoinCodeUri(channelId, coinId);
        System.out.println("I wanna to know: "+coinMappingUrl);
        
        RestTemplate restTemplate = new RestTemplate();
        
        return restTemplate.getForObject(coinMappingUrl, CoinAndTransactionInfo.class);
        
    }

    private CoinToListDto callThirdpartyAPI(String baseURI,String serviceVers, List<String> coinCodes){
        String callUrl = methodURL.generateApiCoinToUsd(baseURI, serviceVers, coinCodes);
        System.out.println("another url that I wanna know: "+callUrl);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(callUrl, CoinToListDto.class);
    }

    @Override
    public CoinToListDto coinToUsdService(Long channelId, List<String> coinIds) {
        // call db get coinCode and how to construct api
        CoinAndTransactionInfo info = callToCoinMapping(channelId, coinIds);

        // then call api that call third party api
        //if congeecko, then it is 
        String baseURI = info.getChannelUrl();
        String serviceVers = info.getChannelTransaction().getDomainVersion();
        List<String> coinCodes = info.getCoinMappings().stream().map(x->x.getCoinCode()).toList();
        return callThirdpartyAPI(baseURI, serviceVers, coinCodes);
    }
    
}
