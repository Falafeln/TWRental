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
       c.setName(car.getName());
       c.setModel(car.getModel());
       c.setAc(car.isAc());
       c.setSeats(car.getSeats());
       c.setCost_per_day(car.getCost_per_day());
       c.setTransmission(car.getTransmission());


       carRepository.save(c);

        return c;
    }

    @Override
    public void deleteCar(int id) {
        carRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Car", "car_id", id));
        carRepository.deleteById(id);

    }



}
