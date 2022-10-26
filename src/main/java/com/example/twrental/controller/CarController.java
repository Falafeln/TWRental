package com.example.twrental.controller;

import com.example.twrental.model.Car;
import com.example.twrental.model.Customer;
import com.example.twrental.repository.CarRepository;
import com.example.twrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarRepository carRepository;

  /*  @GetMapping("/cars") // !!!! MÅSTE ATT HA FUNGERANDE !!!!!!!!! <-- Kund ska kunna göra detta
    public List <Car> findAvailableCar(boolean booked){
        return carRepository.findCarByBookedOrderByModel(false);
    }*/



    @PostMapping("/addcar") // !!!! MÅSTE ATT HA FUNGERANDE !!!!!!!!! <-- ADMIN ska kunna göra detta
    public ResponseEntity<Car> addcar(@RequestBody Car c){
        return new ResponseEntity<Car>(carService.saveCar(c), HttpStatus.CREATED);
    }

    @PutMapping("/updatecar/{car_id}") // !!!! MÅSTE ATT HA FUNGERANDE !!!!!!!!! <-- ADMIN ska kunna göra detta
    public ResponseEntity<Car> updateCar(@PathVariable("car_id") int id, @RequestBody Car car){
        return new ResponseEntity<Car>(carService.updateCar(car,id), HttpStatus.OK);
    }

    @DeleteMapping ("/deletecar/{car_id}") // !!!! MÅSTE ATT HA FUNGERANDE !!!!!!!!! <-- ADMIN ska kunna göra detta
    public ResponseEntity<String>deleteCar(@PathVariable ("car_id") int id){
        carService.deleteCar(id);
        return new ResponseEntity<String>("Car deleted!", HttpStatus.OK);

        // <---- Se till så att om bilen är bokad måste bokningen tas bort först
    }

//__________________________________________





    @GetMapping("/getCar")
    public List<Car> getAllCars(){return carService.getAllCars();}

    @GetMapping("/getCarID{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") int id){
        return new ResponseEntity<Car>(carService.getCarById(id),HttpStatus.OK);
    }





    @GetMapping("/sortCarAsc")
    public List<Car>sortCarAsc(String model){
        return carRepository.findCarByModelOrderByNameAsc(model);
    }

    @GetMapping("/sortCarDesc")
    public List<Car>sortCarDesc(String model){
        return carRepository.findCarByModelOrderByNameDesc(model);
    }



}
