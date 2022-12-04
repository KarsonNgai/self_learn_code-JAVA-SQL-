package com.app.shop_testdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.shop_testdb.entity.Users_products;

@Repository
public interface UserProductRepository extends JpaRepository<Users_products,Long>{
  
}
