package com.crypto_backend.admin.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.crypto_backend.admin.entity.ChannelTransaction;
import com.crypto_backend.admin.entity.Channels;
import com.crypto_backend.admin.entity.CoinMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
        
        dto.setChannelTransaction(ct.orElse(new ChannelTransaction()));
        dto.setCoinMappings(coinMapping);
        return dto;
    }
}
