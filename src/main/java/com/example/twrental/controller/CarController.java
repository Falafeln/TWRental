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

    @PostMapping("/saveCar")
    public ResponseEntity<Car> saveCar(@RequestBody Car c){
        return new ResponseEntity<Car>(carService.saveCar(c), HttpStatus.CREATED);
    }

    @GetMapping("/getCar")
    public List<Car> getAllCars(){return carService.getAllCars();}

    @GetMapping("/getCarID{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") int id){
        return new ResponseEntity<Car>(carService.getCarById(id),HttpStatus.OK);
    }

    @PutMapping("/updatecar/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") int id, @RequestBody Car car){
        return new ResponseEntity<Car>(carService.updateCar(car,id), HttpStatus.OK);
    }

    @GetMapping("/deletecar/{id}")
    public ResponseEntity<String>deleteCar(@PathVariable ("id") int id){
        carService.deleteCar(id);
        return new ResponseEntity<String>("Car deleted!", HttpStatus.OK);
    }

    @GetMapping("/sortCarAsc")
    public List<Car>sortCarAsc(String model){
        return carRepository.findCarByModelOrderByNameAsc(model);
    }

    @GetMapping("/sortCarDesc")
    public List<Car>sortCarDesc(String model){
        return carRepository.findCarByModelOrderByNameDesc(model);
    }

    @GetMapping("/GET/api/v1/cars")
    public List <Car> findAvailableCar(boolean booked){
        return carRepository.findCarByBookedOrderByModel(false);
    }

}
