package com.example.twrental;

import com.example.twrental.model.Car;
import com.example.twrental.repository.CarRepository;
import com.example.twrental.service.CarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TwRentalApplication {

    public static void main(String[] args) {

        SpringApplication.run(TwRentalApplication.class, args);


    }


   /* @Bean
    public CommandLineRunner init(CarService carService){
        return args -> {

            Car car = new Car();
            car.setBooked(false);
            car.setAc(true);
            car.setTransmission("bensin");
            car.setName("NAMN");
            car.setModel("modellen");
            car.setCost_per_day(221);
            car.setSeats(1);

        carService.saveCar(car);

        };
    }*/



    /*
    @Bean //Används för att slippa använda keycloak.json
    public KeyCloakSpringBootConfigResolver keycloakConfigResolver (){
    return new KeyCloakSpringBootConfigResolver();
    }
    */

}
