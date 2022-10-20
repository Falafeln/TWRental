package com.example.twrental.controller;

import com.example.twrental.model.Adress;
import com.example.twrental.repository.AdressRepository;
import com.example.twrental.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AdressController {

    @Autowired
    private AdressService adressService;

    @Autowired
    private AdressRepository adressRepository;

    @PostMapping("/saveAdress")
    public ResponseEntity<Adress> saveAdress(@RequestBody Adress adress){
        return new ResponseEntity<Adress>(adressService.saveAdress(adress), HttpStatus.CREATED);
    }

    @GetMapping("/getAdress")
    public List<Adress> getAllAdress(){return adressService.getAllAdress();}

    @GetMapping("/adressID{id}")
    public ResponseEntity<Adress> getAdressById(@PathVariable("id") int id){
        return new ResponseEntity<Adress>(adressService.getAdressById(id),HttpStatus.OK);
    }

    @GetMapping("/updateAdress/{id}")
    public ResponseEntity<Adress> updateAdress(@PathVariable("id") int id, @RequestBody Adress adress){
        return new ResponseEntity<Adress>(adressService.updateAdress(adress,id), HttpStatus.OK);
    }

    @GetMapping("/delete/Adress{id}")
    public ResponseEntity<String>deleteAdress(@PathVariable ("id") int id){
        adressService.deleteAdress(id);
        return new ResponseEntity<String>("Adress deleted!", HttpStatus.OK);
    }

    @GetMapping("/sortAdressAsc")
    public List<Adress>sortAdressAsc(String street){
        return adressRepository.findAdressByStreetOrderByDistrictAsc(street);
    }

    @GetMapping("/sortAdressDesc")
    public List<Adress>sortAdressDesc(String street){
        return adressRepository.findAdressByStreetOrderByDistrictDesc(street);
    }


}
