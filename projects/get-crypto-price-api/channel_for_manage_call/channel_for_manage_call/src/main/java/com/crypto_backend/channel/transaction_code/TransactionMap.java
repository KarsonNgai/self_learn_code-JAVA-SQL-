package com.crypto_backend.channel.transaction_code;

import lombok.Getter;

@Getter
public enum TransactionMap {
    COIN_TO_USD("simple-price","crypto-web"),
    EXCHANGE_RATE_LIST("exchange_rate_list","crypto-app"),
    MARKET_PRICE("market_price","crypto-web");

    String methodUrl;
    String sourceApps;

    TransactionMap(String methodUrl,String sourceApps){
        this.methodUrl=methodUrl;
        this.sourceApps = sourceApps;
    }
}
