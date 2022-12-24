package com.crypto_backend.admin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crypto_backend.admin.entity.ChannelTransaction;

public interface ChannelTransactionRepository extends JpaRepository<ChannelTransaction,Long>{
    Optional<ChannelTransaction> findByDomainUrlAndSourceAppAndChannelId(String domainUrl, String sourceApp, Long channelId);

    boolean existsByChannelIdAndDomainVersionAndDomainUrlAndSourceAppAndTransactionTypeAndTransactionStatus(
            Long channelId, String domainVersion, String domainUrl, String sourceApp, String transactionType,
            String transactionStatus);
}
