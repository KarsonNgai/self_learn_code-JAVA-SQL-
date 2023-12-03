package com.saving_management.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.saving_management.app.entity.TransactionCategory;
import com.saving_management.app.entity.TransactionInSaving;
import com.saving_management.app.entity.TransactionType;
import com.saving_management.app.pojo.ApiResponse;

public interface AppControllerInterface {

        @GetMapping(value = "connection")
        String checkConnection();

        
        @GetMapping(value = "all_saving")
        List<TransactionInSaving> getAll();

        @GetMapping(value = "saving/year/{year}")
        List<TransactionInSaving> getSavingByYear(@PathVariable(value = "year") int year);

        @GetMapping(value = "saving/year/{year}/month/{month}")
        List<TransactionInSaving> getSavingByYearAndMonth(@PathVariable(value = "year") int year,
                        @PathVariable(value = "month") int month);

        @GetMapping(value = "saving/saving_id/{savingId}")
        TransactionInSaving getSavingById(@PathVariable(value = "savingId") Long savingId);

        // tbc
        @PostMapping(value = "saving")
        ApiResponse<String> insertNewSaving(@RequestBody TransactionInSaving saving);

        @PatchMapping(value = "saving/saving_id/{savingId}")
        String updateSavingStatus(@PathVariable(name = "savingId") Long savingId,
                        @RequestParam(name = "isValid") boolean isValidForSaving);

        @PutMapping(value = "saving/saving_id/{savingId}")
        String updateSaving(@PathVariable(value = "savingId") Long savingId, @RequestBody TransactionInSaving saving);

        //create new saving category
        //it can be change to just response the number
        //it does not change if the category name exist in the table
        @PostMapping(value = "transaction-type")
        ApiResponse<Long> createNewTransactionType(@RequestBody TransactionType transactionType);

        @GetMapping(value = "transaction-type")
        ApiResponse<List<TransactionType>> getAllTransactionType();

        @PostMapping(value = "transaction-category")
        ApiResponse<Long> createNewTransactionCategory(@RequestBody TransactionCategory transactionCategory);

        @GetMapping(value = "transaction-category")
        ApiResponse<List<TransactionCategory>> getAllTransactionCategory();
}
