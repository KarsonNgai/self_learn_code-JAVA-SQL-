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
@Table(name = "channel_transaction")
@Data
@NoArgsConstructor
public class ChannelTransaction implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "channel_id")
    Long channelId;

    @Column(name = "domain_version")
    String domainVersion;

    @Column(name = "domain_url")
    String domainUrl;

    @Column(name = "source_app")
    String sourceApp;

    @Column(name = "tran_type")
    String transactionType;

    @Column(name = "tran_status")
    String transactionStatus;

    @ManyToOne
    @JoinColumn(name = "channel_id",insertable = false,updatable = false)
    @JsonIgnore
    Channels channelForTransaction;
}
