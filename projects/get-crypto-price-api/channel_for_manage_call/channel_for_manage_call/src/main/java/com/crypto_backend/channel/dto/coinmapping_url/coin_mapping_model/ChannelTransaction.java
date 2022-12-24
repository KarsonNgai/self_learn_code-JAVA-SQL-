package com.crypto_backend.channel.dto.coinmapping_url.coin_mapping_model;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChannelTransaction implements Serializable{

    Long id;

    Long channelId;

    String domainVersion;

    String domainUrl;

    String sourceApp;

    String transactionType;

    String transactionStatus;

    Date lastUpdatedDate;
}
