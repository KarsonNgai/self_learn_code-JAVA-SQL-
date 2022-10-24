package com.vtxlab.model.Customer;

import java.util.Comparator;

public class CustomerSortById implements Comparator<Customer>{

  @Override
  public int compare(Customer o1, Customer o2) {
    return o1.getId()>o2.getId()?1:
          o1.getId()==o2.getId()?0:-1;
  }
  
}
