package com.example.twrental.service;

import com.example.twrental.model.Booking;

import java.util.List;

public interface BookingServiceInterface {

    Booking cancelOrder(Booking booking, int id);
    Booking orderCar(Booking booking);
    Booking updateOrder(Booking booking, int id);
    List<Booking> myOrder(int id);

    List<Booking>getAllBookings();
    Booking saveOrder(Booking booking);

    void deleteBooking(int id);
}
