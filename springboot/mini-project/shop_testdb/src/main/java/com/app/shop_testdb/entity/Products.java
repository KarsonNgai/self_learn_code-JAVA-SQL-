package com.app.shop_testdb.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Table(name = "products")
@Entity
@Data
public class Products {
  
  @Id
  @Column(name = "product_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long product_id;

  @Column(name = "product_name")
  String product_name;

  @Column(name = "price")
  Integer price;

  @OneToMany(mappedBy = "product")
  @JsonIgnore
  List<Users_products> users_products;
}
