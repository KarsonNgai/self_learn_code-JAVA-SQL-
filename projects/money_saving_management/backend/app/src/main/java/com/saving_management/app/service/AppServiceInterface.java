package com.saving_management.app.service;

import java.util.List;

import com.saving_management.app.entity.TransactionCategory;
import com.saving_management.app.entity.TransactionInSaving;
import com.saving_management.app.entity.TransactionType;

public interface AppServiceInterface {

    List<TransactionInSaving> getAllChangeRecordInSaving();

    List<TransactionInSaving> getSavingByYear(int year);

    List<TransactionInSaving> getSavingByYearAndMonth(int year, int month);

    TransactionInSaving getSavingById(Long savingId);

    String insertNewSaving(TransactionInSaving saving);

    String updateSavingStatus(Long savingId, boolean isValidForSaving);

    String updateSavingById(Long savingId, TransactionInSaving saving);

    Long createNewTransactionType(TransactionType savingCategory);

    List<TransactionType>getAllTransactionType();

    Long createNewTransactionCategory(TransactionCategory transactionCategory);

    List<TransactionCategory> getAllTransactionCategory();
}
