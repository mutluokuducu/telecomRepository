package com.happytelecom.controller;

import com.happytelecom.model.Customer;
import com.happytelecom.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers",method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getAllList(){

        List<Customer> customers =customerService.getAllList();

        if (customers.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }


    @RequestMapping(value = "/customers/{marriedStatus}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable("marriedStatus") String  marriedStatus) {

       List<Customer> customer = customerService.getSingleCustomer(marriedStatus);
        if (customer.isEmpty()) {

            return new ResponseEntity(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<List<Customer>>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {

        customerService.addCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/customer/{id}").buildAndExpand(customer.getId()).toUri());

        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

}
