package com.app.shop_testdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.shop_testdb.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long>{
  
}
