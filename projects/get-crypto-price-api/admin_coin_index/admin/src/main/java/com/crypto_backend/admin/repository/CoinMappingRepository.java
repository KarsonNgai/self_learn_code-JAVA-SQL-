package com.crypto_backend.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crypto_backend.admin.entity.CoinMapping;
public interface CoinMappingRepository extends JpaRepository<CoinMapping,Long>{
    
    List<CoinMapping> findByCoinIdAndChannelId(String coinId, Long channelId);

    List<CoinMapping> findByCoinIdInAndChannelId(Iterable<String> coinId,Long channelId);

    
    Boolean existsByChannelIdAndCoinCodeAndCoinIdAndCoinStatus(Long channelId, String coinCode, String coinId, String coinStatus);

    //no need 
    //https://stackoverflow.com/questions/37253571/spring-data-jpa-difference-between-findby-findallby
    //List<CoinMapping> findAllByCoinIdIn(Iterable<String>coinId)
}
