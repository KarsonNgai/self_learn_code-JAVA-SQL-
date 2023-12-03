package com.saving_management.app.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saving_management.app.controller.AppControllerInterface;
import com.saving_management.app.entity.TransactionCategory;
import com.saving_management.app.entity.TransactionInSaving;
import com.saving_management.app.entity.TransactionType;
import com.saving_management.app.pojo.ApiResponse;
import com.saving_management.app.service.AppServiceInterface;

@RestController
@RequestMapping(value = "saving_management/api/v1")
@CrossOrigin
public class AppController implements AppControllerInterface {

    @Autowired
    AppServiceInterface appService;

    @Override
    public String checkConnection() {
        return "connected";
    }

    @Override
    public List<TransactionInSaving> getAll() {
        return appService.getAllChangeRecordInSaving();

    }

    @Override
    public List<TransactionInSaving> getSavingByYear(int year) {
        return appService.getSavingByYear(year);
    }

    @Override
    public List<TransactionInSaving> getSavingByYearAndMonth(int year, int month) {
        return appService.getSavingByYearAndMonth(year, month);
    }

    @Override
    public TransactionInSaving getSavingById(Long savingId) {
        return appService.getSavingById(savingId);
    }

    @Override
    public ApiResponse<String> insertNewSaving(TransactionInSaving saving) {
        String result = appService.insertNewSaving(saving);
        return new ApiResponse<>(result, "");
    }

    @Override
    public String updateSavingStatus(Long savingId, boolean isValidForSaving) {
        return appService.updateSavingStatus(savingId, isValidForSaving);
    }

    @Override
    public String updateSaving(Long savingId, TransactionInSaving saving) {
        return appService.updateSavingById(savingId, saving);
    }

    @Override
    public ApiResponse<Long> createNewTransactionType(TransactionType transactionType){
        Long result = appService.createNewTransactionType(transactionType);
        //it can be using the RestControllerAdvise
        if(result.equals(-1L)){
            return new ApiResponse<Long>(400, null, "type name repeated");
        }
        return new ApiResponse<>(200, result, "success");
    }

    @Override
    public ApiResponse<List<TransactionType>> getAllTransactionType() {
        return new ApiResponse<List<TransactionType>>(appService.getAllTransactionType(), "success");
    }

    @Override
    public ApiResponse<Long> createNewTransactionCategory(TransactionCategory transactionCategory) {
        Long result = appService.createNewTransactionCategory(transactionCategory);
        if(result.equals(-1L)){
            return new ApiResponse<Long>(400, null, "category name repeated");
        }
        return new ApiResponse<Long>(200, result, "success");
    }

    @Override
    public ApiResponse<List<TransactionCategory>> getAllTransactionCategory() {
        return new ApiResponse<>(appService.getAllTransactionCategory(), "success");
    }
        

}
