package com.example.twrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwRentalApplication.class, args);
    }



    /*
    @Bean //Används för att slippa använda keycloak.json
    public KeyCloakSpringBootConfigResolver keycloakConfigResolver (){
    return new KeyCloakSpringBootConfigResolver();
    }
    */

}
