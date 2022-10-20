package com.example.twrental.service;

import com.example.twrental.exception.ResourceNotFoundException;
import com.example.twrental.model.Car;
import com.example.twrental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements CarServiceInterface {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(int id) {
        Optional<Car> car = carRepository.findById(id);
        if(car.isPresent()){
            return car.get();
        }else {
            throw new ResourceNotFoundException("Car", "Id", car);
        }

    }

    @Override
    public Car updateCar(Car car, int id) {
        Car c = carRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Car", "Id", id));
       c.setName(c.getName());
       c.setModel(c.getModel());
       c.setAc(c.isAc());
       c.setSeats(c.getSeats());
       c.setCost_per_day(c.getCost_per_day());
       c.setTransmission(c.getTransmission());
       c.setBooked(c.isBooked());

       carRepository.save(c);

        return c;
    }

    @Override
    public void deleteCar(int id) {
        carRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Car", "id", id));
        carRepository.deleteById(id);

    }

    @Override
    public Car createCar() {
        //boolean booked, int seat, double costPerDay, String model, String name, boolean ac, String transmission
        Car c = new Car();
        c.setBooked(false);
        c.setSeats(2);
        c.setCost_per_day(2333);
        c.setModel("Test");
        c.setName("Volvo");
        c.setAc(true);
        c.setTransmission("Kvävgas");
        carRepository.save(c);
        return c;
    }


}
