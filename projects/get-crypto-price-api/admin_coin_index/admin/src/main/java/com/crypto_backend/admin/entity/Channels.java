package com.crypto_backend.admin.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdatedDate;
    
    @OneToMany(mappedBy = "channelForTransaction")
    @JsonIgnore
    private List<ChannelTransaction> channelTransactions;

    @OneToMany(mappedBy = "channelsForCoin")
    @JsonIgnore
    private List<CoinMapping> coinMapping;

    @PrePersist
    private void onCreate(){
        lastUpdatedDate = new Date();
    }
    //generate the time in yyyy:MM:dd HH:mm:ss : https://www.youtube.com/watch?v=a4FELDK19Ak
}
