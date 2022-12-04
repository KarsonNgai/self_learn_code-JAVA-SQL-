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

@Table(name = "users")
@Entity
@Data
public class Users {
  
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  Long user_id;

  @Column(name = "user_name")
  String user_name;


  @OneToMany(mappedBy = "user")
  @JsonIgnore
  List<Users_products> users_products;
}
