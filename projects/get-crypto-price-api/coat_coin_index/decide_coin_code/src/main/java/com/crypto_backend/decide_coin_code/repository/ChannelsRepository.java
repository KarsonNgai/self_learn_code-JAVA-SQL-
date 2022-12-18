package com.crypto_backend.decide_coin_code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crypto_backend.decide_coin_code.entity.Channels;

public interface ChannelsRepository extends JpaRepository<Channels,Long>{
    List<Channels> findByCoinMappingCoinId(String coinId);
}
