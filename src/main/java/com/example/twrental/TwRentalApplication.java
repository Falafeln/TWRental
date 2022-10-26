package com.example.twrental;


import com.example.twrental.model.Admin;
import com.example.twrental.model.Adress;
import com.example.twrental.model.Booking;
import com.example.twrental.model.Customer;

import com.example.twrental.service.AdminService;
import com.example.twrental.service.AdressService;

import com.example.twrental.service.CustomerService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TwRentalApplication {

    public static void main(String[] args) {

        SpringApplication.run(TwRentalApplication.class, args);


    }


   @Bean
    public CommandLineRunner init(){
        return args -> {
        };
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }



    /*
    @Bean //Används för att slippa använda keycloak.json
    public KeyCloakSpringBootConfigResolver keycloakConfigResolver (){
    return new KeyCloakSpringBootConfigResolver();
    }
    */

}
