package com.example.twrental.repository;

import com.example.twrental.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer>findCustomerByUsernameOrderByUsernameAsc(String username);
    List<Customer>findCustomerByUsernameOrderByUsernameDesc(String username);

    @Query("from Customer u where u.username = :s")
    Optional<Customer> findByUsername(@Param("s") String value);
}
