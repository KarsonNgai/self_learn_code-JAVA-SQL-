package com.crypto_backend.decide_coin_code.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.crypto_backend.decide_coin_code.entity.ChannelTransaction;
import com.crypto_backend.decide_coin_code.entity.Channels;
import com.crypto_backend.decide_coin_code.entity.CoinMapping;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoinAndTransactionInfo implements Serializable{
    private Long channelId;

    private String channelCode;
    
    private String channelUrl;

    private String lastUpdDate;

    private ChannelTransaction channelTransaction;

    private List<CoinMapping> coinMappings;

    public static CoinAndTransactionInfo toDto(Optional<ChannelTransaction> ct, List<CoinMapping> coinMapping, Channels channelForCoin){
        CoinAndTransactionInfo dto = new CoinAndTransactionInfo();

        dto.setChannelId(channelForCoin.getId());
        dto.setChannelCode(channelForCoin.getChannelCode());
        dto.setChannelUrl(channelForCoin.getChannelUrl());
        dto.setLastUpdDate(channelForCoin.getLastUpdatedDate());
        
        dto.setChannelTransaction(ct.orElse(new ChannelTransaction()));
        dto.setCoinMappings(coinMapping);
        return dto;
    }
}
