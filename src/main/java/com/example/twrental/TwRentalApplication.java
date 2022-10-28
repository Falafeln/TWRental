package com.example.twrental;

//import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
public class TwRentalApplication {

    public static void main(String[] args) {

        SpringApplication.run(TwRentalApplication.class, args);


    }


    @Bean
    @LoadBalanced
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
