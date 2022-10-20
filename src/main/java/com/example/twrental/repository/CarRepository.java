package com.example.twrental.repository;

import com.example.twrental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findCarByModelOrderByNameAsc(String model);
    List<Car> findCarByModelOrderByNameDesc(String model);

    List <Car> findCarByBookedOrderByModel(boolean booked);

}
