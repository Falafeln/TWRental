package com.example.twrental.repository;

import com.example.twrental.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer>findCustomerByUsernameOrderByUsernameAsc(String username);
    List<Customer>findCustomerByUsernameOrderByUsernameDesc(String username);
}
