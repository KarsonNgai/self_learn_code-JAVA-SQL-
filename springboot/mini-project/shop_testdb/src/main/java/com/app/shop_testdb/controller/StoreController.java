package com.app.shop_testdb.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.shop_testdb.entity.Products;
import com.app.shop_testdb.entity.Users;
import com.app.shop_testdb.entity.Users_products;
import com.app.shop_testdb.repository.ProductRepository;
import com.app.shop_testdb.repository.UserProductRepository;
import com.app.shop_testdb.repository.UserRepository;

@RestController
@RequestMapping(value = "api")
public class StoreController {
  
  @Autowired
  ProductRepository productRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserProductRepository userProductRepository;
  
  @GetMapping(value = "check")
  public String check(){
    return "connected !!" ;
  }

  @GetMapping(value = "findAllProduct")
  public List<Products> findAllProduct(){
    return productRepository.findAll();
  }


  @GetMapping(value = "findAllUser")
  public List<Users> findAllUser(){
    return userRepository.findAll();
  }

  @GetMapping(value = "findAll")
  public List<Users_products> findAll(){
    return userProductRepository.findAll();
  }
}
