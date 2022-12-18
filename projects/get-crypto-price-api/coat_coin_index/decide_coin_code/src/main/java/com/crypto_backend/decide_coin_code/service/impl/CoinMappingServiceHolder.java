package com.crypto_backend.decide_coin_code.service.impl;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.crypto_backend.decide_coin_code.dto.CoinAndTransactionInfo;
import com.crypto_backend.decide_coin_code.entity.ChannelTransaction;
import com.crypto_backend.decide_coin_code.entity.Channels;
import com.crypto_backend.decide_coin_code.entity.CoinMapping;
import com.crypto_backend.decide_coin_code.repository.ChannelTransactionRepository;
import com.crypto_backend.decide_coin_code.repository.CoinMappingRepository;
import com.crypto_backend.decide_coin_code.service.CoinMappingService;

@Service
public class CoinMappingServiceHolder implements CoinMappingService{

    @Autowired
    CoinMappingRepository coinMappingRepository;

    @Autowired
    ChannelTransactionRepository channelTransactionRepository;

    @Autowired
    RedisTemplate<String,CoinAndTransactionInfo> redisTemplate;
    

    private Optional<ChannelTransaction> getChannelTransactionById(Long channelTransactionId){
        return channelTransactionRepository.findById(channelTransactionId);
    }

    private List<CoinMapping> getCoinMappingWithChannelByCoinIdAndChannelId(Long channelId,List<String> coinId){
        return coinMappingRepository.findByCoinIdInAndChannelId(coinId, channelId);
    }

    private Channels getChannelsFromCoinMappings(List<CoinMapping> coinMappings){
        return coinMappings.get(0).getChannelsForCoin();
    }

    @Override
    public CoinAndTransactionInfo getAllWithDto(Long channelId, Long channelTransactionId, List<String> coinId) {
        String redisKey = this.generatedRedisKey(channelId, channelTransactionId, coinId);
        if(redisTemplate.opsForValue().get(redisKey)!=null){
            return redisTemplate.opsForValue().get(redisKey);
        }
       
        //get channel transaction
        Optional<ChannelTransaction> channelTran = getChannelTransactionById(channelTransactionId);
        
        //get coinId
        List<CoinMapping> coinMappings = getCoinMappingWithChannelByCoinIdAndChannelId(channelId, coinId);
        
        //get channel
        Channels channelForCoin = getChannelsFromCoinMappings(coinMappings);

        //to dto
        CoinAndTransactionInfo returned = CoinAndTransactionInfo.toDto(channelTran, coinMappings, channelForCoin);

        redisTemplate.opsForValue().set(redisKey, returned,Duration.ofMinutes(10L)); //can be better with async

        return returned;
    }

    @Override
    public void insertNewCoin(Long channelId, String coinCode, String coinId, String coinStatus) {
        CoinMapping insertEntity = new CoinMapping();
        insertEntity.setChannelId(channelId);
        insertEntity.setCoinCode(coinCode);
        insertEntity.setCoinId(coinId);
        insertEntity.setCoinStatus(coinStatus);

        coinMappingRepository.save(insertEntity);
        
    }

    // save key
    private String generatedRedisKey(Long channelId, Long channelTransactionId, List<String> coinId){
        StringBuilder key = new StringBuilder();
        return key.append("channelId:")
            .append(channelId)
            .append("channelTransactionId:")
            .append(channelTransactionId)
            .append("coinId:")
            .append(String.join(",", coinId)).toString();        
    }

    // get if yes, else save
    
}
