package com.saving_management.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saving_management.app.entity.TransactionCategory;

public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Long> {

    List<TransactionCategory> findAllByTransactionCategoryName(String transactionCategoryName);

}
