package com.crypto_backend.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crypto_backend.admin.entity.Channels;

public interface ChannelsRepository extends JpaRepository<Channels,Long>{
    List<Channels> findByCoinMappingCoinId(String coinId);

    boolean existsByChannelCodeAndChannelUrl(String channelCode, String channelUrl);
}
