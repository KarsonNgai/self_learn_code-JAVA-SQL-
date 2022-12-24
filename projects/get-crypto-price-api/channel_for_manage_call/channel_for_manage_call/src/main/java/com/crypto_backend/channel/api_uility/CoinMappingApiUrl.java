package com.crypto_backend.channel.api_uility;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.crypto_backend.channel.transaction_code.TransactionMap;

@Component
public class CoinMappingApiUrl {
    @Value("${validation.coin-code.baseUrl}")
    String callDatabaseBaseUrl;

    @Value("${validation.coin-code.serviceVers}")
    String callDatabaseServiceVers;

    @Value("${validation.coin-code.method}")
    String getCoinInfo;

    private UriComponentsBuilder buildUri(){
        return UriComponentsBuilder.fromUri(URI.create("http://"+callDatabaseBaseUrl))
        //fromUriString(this.callDatabaseBaseUrl)
                                    .pathSegment(this.callDatabaseServiceVers);
    }

    public String getCoinCodeUri(Long channelId,List<String> coinId){
        return buildUri()
                .path(this.getCoinInfo)
                .queryParam("channelId", channelId)
                .queryParam("domainUrl", TransactionMap.COIN_TO_USD.getMethodUrl())
                .queryParam("sourceApp", TransactionMap.COIN_TO_USD.getSourceApps())
                .queryParam("coinId", coinId)
                .build().toString();
    }

}
