package com.vtxlab.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.vtxlab.model.Customer.Customer;
import com.vtxlab.model.Customer.CustomerSortByDate;
import com.vtxlab.model.Customer.CustomerSortById;
import com.vtxlab.model.Customer.CustomerSortByName;

public class CollectionsSorting {

  public static void comparing(List<Customer> customers){    
    Collections.sort(customers); //default sort by int
    System.out.println("After Sorting "+customers+"\n\n");
  }

  public static void comparing(List<Customer> customers, Comparator<Customer> comp){    
    Collections.sort(customers, comp);
    System.out.println("After Sorting "+customers+"\n\n");
  }

  public static Comparator<Customer> sortBy(int choice){
    switch(choice){
      case 1:
        return new CustomerSortByDate();
      case 2:
        return new CustomerSortByName();
      default:
        return new CustomerSortById();
    }
  }

  public static Comparator<Customer> sortBy(String choice){
    switch(choice){
      case "date":
        return new CustomerSortByDate();
      case "name":
        return new CustomerSortByName();
      default:
        return new CustomerSortById();
    }
  }

  public static Comparator<Customer> sortBy(){
    return new CustomerSortById();
  }

  public static void main(String[] args) {
    Customer customer1 = new Customer(1,"Alex",LocalDate.of(2022,1,1));
    Customer customer2 = new Customer(2, "Benny", LocalDate.of(2022, 1, 15));
    Customer customer3 = new Customer(3, "Vincent", LocalDate.of(2022, 9, 15));
    Customer customer4 = new Customer(4, "Tommy", LocalDate.of(2022, 8, 3));

    List<Customer> customers = new ArrayList<>();
    customers.add(customer4);
    customers.add(customer3);
    customers.add(customer2);
    customers.add(customer1);

    System.out.println("Before Sorting "+customers+"\n\n=====:");
    //comparing(customers);

    comparing(customers, sortBy("date"));
    comparing(customers, sortBy("name"));
    comparing(customers, sortBy(23124));

  }
}
