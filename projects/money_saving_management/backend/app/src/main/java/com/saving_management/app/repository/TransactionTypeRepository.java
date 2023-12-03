package com.saving_management.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saving_management.app.entity.TransactionType;

public interface TransactionTypeRepository extends JpaRepository<TransactionType ,Long>{
    List<TransactionType> findAllByTransactionTypeName(String transactionTypeName);
}
