package com.crypto_backend.decide_coin_code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crypto_backend.decide_coin_code.entity.CoinMapping;
public interface CoinMappingRepository extends JpaRepository<CoinMapping,Long>{
    
    List<CoinMapping> findByCoinIdAndChannelId(String coinId, Long channelId);

    List<CoinMapping> findByCoinIdInAndChannelId(Iterable<String> coinId,Long channelId);

    //no need 
    //https://stackoverflow.com/questions/37253571/spring-data-jpa-difference-between-findby-findallby
    //List<CoinMapping> findAllByCoinIdIn(Iterable<String>coinId)
}
