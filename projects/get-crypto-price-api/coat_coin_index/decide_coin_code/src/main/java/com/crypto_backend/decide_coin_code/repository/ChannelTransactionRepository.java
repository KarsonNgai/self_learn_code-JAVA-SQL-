package com.crypto_backend.decide_coin_code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crypto_backend.decide_coin_code.entity.ChannelTransaction;

public interface ChannelTransactionRepository extends JpaRepository<ChannelTransaction,Long>{
    
}
