package com.example.twrental.service;

import com.example.twrental.exception.ResourceNotFoundException;
import com.example.twrental.model.Customer;
import com.example.twrental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements CustomerServiceInterface {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            return customer.get();
        }else{
            throw new ResourceNotFoundException("Customer", "Id", customer);
        }

    }

    @Override
    public Customer updateCustomer(Customer customer, int id) {
        Customer c = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer", "Id", id));
        c.setFirst_name(customer.getFirst_name());
        c.setLast_name(customer.getLast_name());
        c.setUsername(customer.getUsername());
        c.setPwd(customer.getPwd());
        c.setEmail(customer.getEmail());
        c.setPhone(customer.getPhone());
        c.setAdress(customer.getAdress());


     //   c.setBookings(c.getBookings());

        customerRepository.save(c);
        return c;
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));
        customerRepository.deleteById(id);
    }
}
