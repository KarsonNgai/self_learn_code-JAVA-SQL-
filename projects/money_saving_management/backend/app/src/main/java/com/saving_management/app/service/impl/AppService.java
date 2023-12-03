package com.saving_management.app.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saving_management.app.entity.TransactionCategory;
import com.saving_management.app.entity.TransactionInSaving;
import com.saving_management.app.entity.TransactionType;
import com.saving_management.app.repository.TransactionTypeRepository;
import com.saving_management.app.repository.TransactionCategoryRepository;
import com.saving_management.app.repository.TransactionInSavingRepository;
import com.saving_management.app.service.AppServiceInterface;

@Service
public class AppService implements AppServiceInterface {

    @Autowired
    TransactionInSavingRepository savingRepository;

    @Autowired
    TransactionCategoryRepository transactionCategoryRepository;

    @Autowired
    TransactionTypeRepository transactionTypeRespository;


    @Override
    public List<TransactionInSaving> getAllChangeRecordInSaving() {

        return savingRepository.findAllByOrderByTransactionDateAsc();
    }

    @Override
    public List<TransactionInSaving> getSavingByYear(int year) {
        Date StartDate = Date.valueOf(String.valueOf(year) + "-01-01");
        Date endDate = Date.valueOf(String.valueOf(year) + "-12-31");

        return savingRepository.findAllByTransactionDateBetween(StartDate, endDate);
    }

    @Override
    public List<TransactionInSaving> getSavingByYearAndMonth(int year, int month) {

        Date StartDate = Date.valueOf(String.valueOf(year) + "-" + String.valueOf(month) + "-01");

        Date endDate = Date.valueOf(String.valueOf(year) + "-" + String.valueOf(month) + this.numberOfMonthInDay(year,month));
        return savingRepository.findAllByTransactionDateBetween(StartDate, endDate);
    }

    @Override
    public TransactionInSaving getSavingById(Long savingId) {
        return savingRepository.findById(savingId).orElse(null);
    }

    @Override
    public String insertNewSaving(TransactionInSaving saving) {
        TransactionInSaving insertSaving = new TransactionInSaving();
        insertSaving.setTransactionDate(saving.getTransactionDate());
        insertSaving.setTransactionAmount(saving.getTransactionAmount());
        insertSaving.setTransactionCategoryId(saving.getTransactionCategoryId());
        savingRepository.save(insertSaving);
        return "success";
    }

    // it is kind of meaningless, not exactly update
    @Override
    public String updateSavingStatus(Long savingId, boolean isValidForSaving) {
        TransactionInSaving targetedSaving = this.getSavingById(savingId);
        if (Objects.isNull(targetedSaving))
            return "target id not found";

        savingRepository.save(targetedSaving);

        return "success";
    }

    @Override
    public String updateSavingById(Long savingId, TransactionInSaving saving) {

        TransactionInSaving insertSaving = new TransactionInSaving();
        insertSaving.setTransactionId(savingId);
        insertSaving.setTransactionDate(saving.getTransactionDate());
        insertSaving.setTransactionAmount(saving.getTransactionAmount());
        // null
        insertSaving.setTransactionCategoryId(saving.getTransactionCategoryId());

        // last modify date not exist
        savingRepository.save(insertSaving);
        return "success";
    }

    private String numberOfMonthInDay(int year, int month){
        switch(month){
            case 1,3,5,7,8,10,12:
                return "-31";
            case 2:
                if(year%4==0){
                    return "-29";
                }
                return "-28";
            default:
                return "-30";
        }
    }

    public Long createNewTransactionType(TransactionType transactionType){
        //check if the name exist before
        List<TransactionType> checked = transactionTypeRespository.findAllByTransactionTypeName(transactionType.getTransactionTypeName());
        if(checked.size()>0) return -1L;
        
        //after check save and return the saving category id
        TransactionType savedData = transactionTypeRespository.saveAndFlush(transactionType);
        return savedData.getTransactionTypeId();


    }

    public List<TransactionType> getAllTransactionType(){
        return transactionTypeRespository.findAll();
    }

    @Override
    public Long createNewTransactionCategory(TransactionCategory transactionCategory) {
        //check if the name exist before
        List<TransactionCategory> checked = transactionCategoryRepository.findAllByTransactionCategoryName(transactionCategory.getTransactionCategoryName());
        if(checked.size()>0)return -1L;

        //after check save and return the saving category id
        TransactionCategory savedData = transactionCategoryRepository.saveAndFlush(transactionCategory);
        return savedData.getTransactionCategoryId();
    }

    @Override
    public List<TransactionCategory> getAllTransactionCategory(){
        return transactionCategoryRepository.findAll();
    }
}
