package com.saving_management.app.entity;

import java.sql.Date;
import java.time.LocalDate;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "transaction_in_saving")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionInSaving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    Long transactionId;

    @Column(name = "transaction_date")
    Date transactionDate;

    @Column(name = "transaction_amount")
    long transactionAmount;

    //default setting is 1L, mean nothing, require to modify later
    @Column(name = "transaction_category_id")
    Long transactionCategoryId = 1L;

    @Column(name = "last_modify_date")
    @Nullable
    Date lastModifyDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "transaction_category_id", insertable = false, updatable = false)
    //@JsonIgnore
    TransactionCategory transactionCategory;

    @PrePersist
    @PreUpdate
    private void onCreate() {
        lastModifyDate = Date.valueOf(LocalDate.now());
    }
}
