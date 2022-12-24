package com.crypto_backend.admin.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.crypto_backend.admin.dto.CoinAndTransactionInfo;
import com.crypto_backend.admin.entity.ChannelTransaction;
import com.crypto_backend.admin.entity.Channels;
import com.crypto_backend.admin.entity.CoinMapping;


public interface CoinMappingOperation {
    @GetMapping("coin_info")
    //channels_id
    //tran id
    //coin id (self define)
    // -> url (how we contruct our api for calling third party), coin_code (for calling third party api), status
    //dto channels
    CoinAndTransactionInfo getAllWithDto(@RequestParam Long channelId, 
                                        @RequestParam String demainUrl,
                                        @RequestParam String sourceApp, 
                                        @RequestParam List<String>coinId);
                                        
    //insert with require parm

    @PostMapping("channels")
    void insertChannels(@RequestParam String channelCode, 
                        @RequestParam String channelUrl, 
                        @RequestParam UUID uuid);

    @PostMapping("coin_mapping")
    void insertCoinMapping(@RequestParam Long channelId,
                            @RequestParam String coinCode,
                            @RequestParam String coinId,
                            @RequestParam String coinStatus, UUID uuid);

    @PostMapping("channel_transaction")
    void insertChannelTransaction(@RequestParam Long channelId, 
                                @RequestParam String dominVersion, 
                                @RequestParam String domainUrl, 
                                @RequestParam String sourceApp, 
                                @RequestParam String transactionType, 
                                @RequestParam String transactionStatus,
                                @RequestParam UUID uuid);

    // insert with whole object
    @PostMapping("channels/notready")
    void insertChannels(@RequestBody Channels channels, UUID uuid);

    @PostMapping("coin_mapping/notready")
    void insertCoinMapping(@RequestBody CoinMapping coinMapping, UUID uuid);

    @PostMapping("channel_transaction/notready")
    void insertChannelTransaction(@RequestBody ChannelTransaction channelTransaction, UUID uuid);

    // below is quite the same
    //post may require the checking for the id(tbc)
    @PostMapping("coin_info/newInfo/notready")
    void insertWholeNewInfo(@RequestBody CoinAndTransactionInfo coinAndTransactionInfo);

    //post should be founded by id on each entity (tbc)
    @PutMapping("coin_info/newInfo/notready")
    void updateWholeInfo(@RequestBody CoinAndTransactionInfo coinAndTransactionInfo);
}
