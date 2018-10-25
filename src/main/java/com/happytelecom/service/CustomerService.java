package com.happytelecom.service;

import com.happytelecom.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer>getAllList();
    List<Customer>getSingleCustomer(String marriedStatus);
    Customer addCustomer(Customer customer);

}
