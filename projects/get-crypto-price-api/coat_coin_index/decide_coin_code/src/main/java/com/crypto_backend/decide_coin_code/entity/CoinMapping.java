package com.crypto_backend.decide_coin_code.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coin_mapping")
@Data
@NoArgsConstructor
public class CoinMapping implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "channel_id")
    Long channelId;

    @Column(name = "coin_code")
    String coinCode;

    @Column(name = "coin_id")
    String coinId;

    @Column(name = "coin_status")
    String coinStatus;

    @ManyToOne
    @JoinColumn(name = "channel_id",insertable = false,updatable = false)
    @JsonIgnore
    Channels channelsForCoin;

}
