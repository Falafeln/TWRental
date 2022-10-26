package com.example.twrental.repository;

import com.example.twrental.model.Booking;
import com.example.twrental.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findBookingByCustomer(Customer customer);


}
