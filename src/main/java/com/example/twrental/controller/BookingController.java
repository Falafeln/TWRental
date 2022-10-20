package com.example.twrental.controller;

import com.example.twrental.repository.BookingRepository;
import com.example.twrental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

    @Autowired
    private BookingService bookingS;

    @Autowired
    private BookingRepository bookingR;






}
