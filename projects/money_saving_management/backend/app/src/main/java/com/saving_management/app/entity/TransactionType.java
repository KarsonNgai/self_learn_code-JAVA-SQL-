package com.saving_management.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "transaction_type")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_type_id")
    Long transactionTypeId;

    @Column(name = "transaction_type_name")
    String transactionTypeName;

    @Column(name = "transaction_type_detail")
    String transactionTypeDetail;

    @Column(name = "is_valid")
    boolean isValid = true;

    @OneToMany(mappedBy = "transactionType", cascade = CascadeType.PERSIST)
    @JsonIgnore
    List<TransactionCategory> transactionCategory;
}
