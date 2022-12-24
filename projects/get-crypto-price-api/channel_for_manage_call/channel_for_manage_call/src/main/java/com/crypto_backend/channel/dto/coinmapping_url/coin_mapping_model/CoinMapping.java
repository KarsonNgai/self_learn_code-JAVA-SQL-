package com.crypto_backend.channel.dto.coinmapping_url.coin_mapping_model;

import java.io.Serializable;
import java.util.Date;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoinMapping implements Serializable{
    
    Long id;

    Long channelId;

    String coinCode;

    String coinId;

    String coinStatus;

    Date lastUpdatedDate;

}
