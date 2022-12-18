package com.crypto_backend.decide_coin_code.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "channels")
@Data
@NoArgsConstructor
public class Channels implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "channel_code")
    String channelCode;

    @Column(name = "channel_url")
    String channelUrl;

    @Column(name = "last_updated_date")
    String lastUpdatedDate;
    
    @OneToMany(mappedBy = "channelForTransaction")
    @JsonIgnore
    private List<ChannelTransaction> channelTransactions;

    @OneToMany(mappedBy = "channelsForCoin")
    @JsonIgnore
    private List<CoinMapping> coinMapping;
}
