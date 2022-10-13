package com.example.twrental.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello") // det är "/hello" som är en endpoint
    public String helloWorld(){return "Hello world!";}
}
