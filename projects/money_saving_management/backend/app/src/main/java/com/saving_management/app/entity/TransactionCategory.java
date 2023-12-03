package com.saving_management.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "transaction_category")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_category_id")
    Long transactionCategoryId;

    @Column(name= "transaction_type_id")
    Long transactionTypeId;

    @Column(name = "transaction_category_name")
    String transactionCategoryName;

    @Column(name = "transaction_category_detail")
    String transactionCategoryDetail;

    @Column(name = "is_valid")
    boolean isValid = true;

    @Column(name = "is_fixed")
    boolean isFixed = false;

    @OneToMany(mappedBy = "transactionCategory", cascade = CascadeType.PERSIST)
    @JsonIgnore
    List<TransactionInSaving> saving;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "transaction_type_id", insertable = false, updatable = false)
    //@JsonIgnore
    TransactionType transactionType;

}
