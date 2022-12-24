package com.crypto_backend.channel.api_uility;

import java.net.URI;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.crypto_backend.channel.transaction_code.TransactionMap;

@Component
public class MethodURL {
    private UriComponentsBuilder baseUrI(String baseURI,String serviceVers){
        return UriComponentsBuilder.fromUri(URI.create("http://"+baseURI))
                                    //localhost:8080/crypto/coingecko
                                    .pathSegment(serviceVers);
                                    //api/v1
    }                              

    
    public String generateApiCoinToUsd(String baseURI,String serviceVers,List<String> coinCodes){
        return baseUrI(baseURI, serviceVers)
                .pathSegment(TransactionMap.COIN_TO_USD.getMethodUrl()) //method name tbc
                .queryParam("coins", coinCodes)
                .build().toString(); //coin code
    }
}
