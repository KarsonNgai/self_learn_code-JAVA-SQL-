package com.vtxlab.model.Customer;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Comparable<Customer>{

  private int id;

  private String name;

  private LocalDate joinDate;

  //default 用id set, my design
  @Override
  public int compareTo(Customer o){
    return Integer.compare(this.id, o.getId());
  }
}
