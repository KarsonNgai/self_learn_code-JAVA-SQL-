package com.crypto_backend.admin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

    @Column(name = "last_updated_date")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdatedDate;

    @ManyToOne
    @JoinColumn(name = "channel_id",insertable = false,updatable = false)
    @JsonIgnore
    Channels channelsForCoin;

    @PrePersist
    private void onCreate(){
        lastUpdatedDate = new Date();
    }
}
