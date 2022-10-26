package com.example.twrental.service;

import com.example.twrental.VO.ResponseTemplateVO;
import com.example.twrental.exception.ResourceNotFoundException;
import com.example.twrental.model.Booking;
import com.example.twrental.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService implements BookingServiceInterface{

    @Autowired
    private BookingRepository bookingR;

    @Autowired
    private CustomerService customerService;



    @Override  //Admin
    public Booking cancelOrder(Booking booking, int id) {
        Booking b = bookingR.findById(id).orElseThrow(()->new ResourceNotFoundException("Booking", "Id", id));
        b.setCustomer(booking.getCustomer());
        b.setCar(booking.getCar());
        b.setRent_date(LocalDateTime.now());
        b.setReturn_date(LocalDateTime.now());
        bookingR.save(b);
        return b;
    }

    @Override
    public Booking orderCar(Booking booking) {
        Booking b = new Booking(booking.getCustomer(),booking.getCar());
        bookingR.save(b);

        return b;
    }

    @Override //kund
    public Booking updateOrder(Booking booking, int id) {
        Booking b = bookingR.findById(id).orElseThrow(()->new ResourceNotFoundException("Booking", "Id",id));
        b.setCustomer(booking.getCustomer());
        b.setCar(booking.getCar());
        bookingR.save(b);
        return b;
    }

    @Override
    public List<Booking> myOrder(int id) {
        return bookingR.findBookingByCustomer(customerService.getCustomerById(id));
    }

    @Override
    public Booking saveOrder(Booking booking) {
        return bookingR.save(booking);
    }

    @Override
    public void deleteBooking(int id) {
        bookingR.findById(id).orElseThrow(()-> new ResourceNotFoundException("Booking", "booking_id", id));
        bookingR.deleteById(id);
    }

    @Override
    public List<Booking> getAllBookings(){return bookingR.findAll();}




}
