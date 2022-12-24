package com.crypto_backend.admin.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crypto_backend.admin.entity.UpdatedId;

public interface UpdatedIdRepository extends JpaRepository<UpdatedId,UUID>{
    
}
