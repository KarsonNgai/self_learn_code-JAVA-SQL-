package com.app.shop_testdb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Table(name = "users_products")
@Data
public class Users_products {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  Long user_product_id;

  @ManyToOne
  @JoinColumn(name = "product_id")
  //@JsonIgnore
  Products product;

  @ManyToOne
  @JoinColumn(name = "user_id")
  //@JsonIgnore
  Users user;

  public Products getProduct(){
    return this.product;
  }
}
