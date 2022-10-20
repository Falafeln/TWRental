package com.example.twrental.service;

import com.example.twrental.model.Car;

import java.util.List;

public interface CarServiceInterface {

    Car saveCar(Car car);
    List<Car>getAllCars();
    Car getCarById(int id);
    Car updateCar(Car car, int id);
    void deleteCar(int id);

    Car createCar();

}
