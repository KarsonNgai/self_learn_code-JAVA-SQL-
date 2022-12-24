package com.crypto_backend.admin.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "updated_id")
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedId {
    @Id
    @Column(name = "id")
    // UUID
    UUID id;    
}
