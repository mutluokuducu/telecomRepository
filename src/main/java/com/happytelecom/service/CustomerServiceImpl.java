package com.happytelecom.service;

import com.happytelecom.model.Customer;
import com.happytelecom.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllList() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public List<Customer> getSingleCustomer(String marriedStatus) {
        return (List<Customer>) customerRepository.findByMarriedStatus(marriedStatus);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        Customer cust=new Customer();
        cust.setFullName(customer.getFullName());
        cust.setMarriedStatus(customer.getMarriedStatus());
        cust.setPhoneNumber(customer.getPhoneNumber());

        return cust;
    }


}
