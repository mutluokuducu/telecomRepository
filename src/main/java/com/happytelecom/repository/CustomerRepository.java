package com.happytelecom.repository;

import com.happytelecom.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Iterable<Customer> findByMarriedStatus(String marriedStatus);
}
