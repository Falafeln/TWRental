package com.example.twrental.controller;

import com.example.twrental.VO.ResponseTemplateVO;
import com.example.twrental.model.Booking;
import com.example.twrental.model.Car;
import com.example.twrental.repository.BookingRepository;
import com.example.twrental.repository.CarRepository;
import com.example.twrental.service.BookingService;
import com.example.twrental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    /*
    KOM IHÅG ATT DET MÅSTE ÄNDRAS PÅ BIL ATT DEN ÄR BOKAD,
    BORDE KANSKE BARA SÖKA DATUM SOM BOKNING ÄR
    OCH OM EN BIL FINNS MED SÅ RÄKNAS DEN SOM BOKAD
     */

    @Autowired
    private BookingService bookingS;

    @Autowired
    private BookingRepository bookingR;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerService customerService;



// MÅSTE HA

    @PostMapping("/ordercar")// BOKA HYRBIL--- POST... /ordercar <--- Kund ska kunna göra detta
    public ResponseEntity <Booking> ordercar(@RequestHeader Integer customerId, @RequestHeader Integer carId){
        List<Car> cars=findAvailableCar();
        Booking booking = new Booking();
        booking.setCar(carRepository.getById(carId));
        booking.setCustomer(customerService.getCustomerById(customerId));
        booking.setRent_date(LocalDateTime.now());
        booking.setReturn_date(LocalDateTime.now().plusDays(3));


        if(cars.contains(booking.getCar())){
            return new ResponseEntity<Booking>(bookingS.saveOrder(booking), HttpStatus.CREATED);
        }
       else {
           //Kolla om man kan få till att det syns i postman
           throw new RuntimeException("Car is not available");

        }
    }


    @PutMapping("/updateorder/") // Uppdatera order --- PUT ... /updateorder  <--- Kund ska kunna göra detta
    public ResponseEntity<Booking>updateorder(
            @RequestHeader Integer booking_id, @RequestHeader Integer day){
        LocalDateTime rent_date = LocalDateTime.now().plusDays(day);
        bookingR.findById(booking_id).get().setRent_date(rent_date);
        bookingR.findById(booking_id).get().setReturn_date(rent_date.plusDays(3));


        return new ResponseEntity<Booking>(bookingS.updateOrder(bookingR.getById(booking_id),booking_id), HttpStatus.OK);
    } //Kolla om jag behöver hämta med bil o kund för att uppdatera


    @GetMapping("/myorders") // Se alla kundens orders ---- GET .... /myorders    <--- Kund ska kunna göra detta
    public List<Booking>sortBookings(@RequestHeader Integer cust_id){
        return bookingR.findBookingByCustomer(customerService.getCustomerById(cust_id));}



    @PutMapping("/cancelorder")//Avboka en order ----- PUT ---- /cancelorder <--- ADMIN SKA KUNNA GÖRA DETTA
    public ResponseEntity<Booking>cancelorder(@RequestHeader Integer booking_id ){
        return new ResponseEntity<Booking>(bookingS.cancelOrder(bookingR.getById(booking_id),booking_id), HttpStatus.OK);}


    @GetMapping("/cars") // !!!! MÅSTE ATT HA FUNGERANDE !!!!!!!!! <-- Kund ska kunna göra detta
    public List <Car> findAvailableCar(){

        LocalDateTime rent_day = LocalDateTime.now();
        LocalDateTime return_date = LocalDateTime.now().plusDays(3);

        List<Booking>bookingList= bookingS.getAllBookings();
        List<Car> cars = carRepository.findAll();

        for(int i=0; i<bookingList.size();i++){
            if(rent_day.isAfter(bookingList.get(i).getRent_date())){
                if(cars.contains(bookingList.get(i).getCar())){
                    cars.remove(bookingList.get(i).getCar());
                }

          } else if (return_date.isBefore(bookingList.get(i).getReturn_date())) {
                if(cars.contains(bookingList.get(i).getCar())){
                    cars.remove(bookingList.get(i).getCar());
                }
            }

        }

        return cars;
    }

    @DeleteMapping("/deleteorder/{booking_id}")
    public ResponseEntity<String>deleteOrder(@PathVariable("booking_id") int id){
        bookingS.deleteBooking(id);
        return new ResponseEntity<String>("Order deleted", HttpStatus.OK);
    }

    @GetMapping("/activeorders")
    public List<Booking> activeorders(){
List<Booking> bookings =bookingR.findAll();

        for(int i = 0;i<bookings.size(); i++){
            if (LocalDateTime.now().isAfter(bookings.get(i).getReturn_date())){
                bookings.remove(i);
            }
        }
        return bookings;
    }

    @GetMapping("/booking/{id}")
    public ResponseTemplateVO getBookingWithExchange(@PathVariable("id") int bookingId){
        return bookingS.getBookingWithExchange(bookingId);
    }


}
