package com.example.twrental.controller;


import com.example.twrental.model.Customer;
import com.example.twrental.repository.CustomerRepository;
import com.example.twrental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/saveCustomer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/getCustomer")
    public List<Customer> getAllCustomers(){return customerService.getAllCustomers();}

    @GetMapping("/getCustomerID{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id){
        return new ResponseEntity<Customer>(customerService.getCustomerById(id),HttpStatus.OK);
    }

    @GetMapping("/updateCustomer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer){
        return new ResponseEntity<Customer>(customerService.updateCustomer(customer,id), HttpStatus.OK);
    }

    @GetMapping("/deleteCustomer/{id}")
    public ResponseEntity<String>deleteCustomer(@PathVariable ("id") int id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<String>("Customer deleted!", HttpStatus.OK);
    }

    @GetMapping("/sortCustomerAsc")
    public List<Customer>sortCustomerAsc(String username){
        return customerRepository.findCustomerByUsernameOrderByUsernameAsc(username);
    }

    @GetMapping("/sortCustomerDesc")
    public List<Customer>sortCustomerDesc(String username){
        return customerRepository.findCustomerByUsernameOrderByUsernameDesc(username);
    }
}
