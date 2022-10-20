package com.example.twrental.service;

import com.example.twrental.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService implements BookingServiceInterface{

    @Autowired
    private BookingRepository bookingR;


}
