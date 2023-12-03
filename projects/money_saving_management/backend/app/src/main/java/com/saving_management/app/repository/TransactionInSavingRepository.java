package com.saving_management.app.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saving_management.app.entity.TransactionInSaving;

public interface TransactionInSavingRepository extends JpaRepository<TransactionInSaving, Long> {
    List<TransactionInSaving> findAllByOrderByTransactionDateAsc();

    List<TransactionInSaving> findAllByTransactionDateBetween(Date startDate, Date endDate);
}
