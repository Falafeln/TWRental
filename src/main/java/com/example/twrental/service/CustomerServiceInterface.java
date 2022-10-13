package com.example.twrental.service;

import com.example.twrental.model.Customer;

import java.util.List;

public interface CustomerServiceInterface {

    Customer saveCustomer(Customer customer);
    List<Customer>getAllCustomers();
    Customer getCustomerById(int id);
    Customer updateCustomer(Customer customer, int id);
    void deleteCustomer(int id);

}
