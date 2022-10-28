package com.example.twrental.service;

import com.example.twrental.VO.Exchange;
import com.example.twrental.VO.ResponseTemplateVO;
import com.example.twrental.exception.ResourceNotFoundException;
import com.example.twrental.model.Booking;
import com.example.twrental.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class BookingService implements BookingServiceInterface{

    @Autowired
    private BookingRepository bookingR;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RestTemplate restTemplate;



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
        //Exchange exchange = restTemplate.getForObject("http://EXCHANGE/exchange/", Exchange.class);
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

 public ResponseTemplateVO getBookingWithExchange(int bookingId){
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Booking booking = bookingR.getById(bookingId);
        long daysBetween = DAYS.between(booking.getRent_date(),booking.getReturn_date());
        //Exchange exchange =new Exchange(bookingId,booking.getCar().getCost_per_day(), (int) daysBetween,bookingId);
        //Exchange exchange = restTemplate.getForObject("http://EXCHANGE/exchange/" + bookingId, Exchange.class);
     Exchange exchange = restTemplate.getForObject("http://EXCHANGE/exchange/" + booking.getCar().getCost_per_day() +"/" + 3, Exchange.class);
        vo.setBooking(booking);
        vo.setExchange(exchange);

        return vo;}




}
