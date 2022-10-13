package com.example.twrental.service;

import com.example.twrental.exception.ResourceNotFoundException;
import com.example.twrental.model.Adress;
import com.example.twrental.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AdressService implements AdressServiceInterface{


    @Autowired
    private AdressRepository adressRepository;

    /*
    public AdressService(AdressRepository adressRepository){
    super();
    this.adressRepository = adressRepository;
    }
     */

    @Override
    public Adress saveAdress(Adress adress){return adressRepository.save(adress);}


    @Override
    public List<Adress> getAllAdress(){return adressRepository.findAll();}

    @Override
    public Adress getAdressById(int id){
        Optional<Adress> adress = adressRepository.findById(id);
        if(adress.isPresent()){
            return adress.get();
        }else {
            throw new ResourceNotFoundException("Adress", "Id", adress);

        }
    }

    @Override
    public Adress updateAdress(Adress adress, int id){
        Adress a = adressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Adress", "Id", id));
        a.setCountry(a.getCountry());
        a.setDistrict(a.getDistrict());
        a.setStreet(a.getStreet());
        a.setStreet_number(a.getStreet_number());
        a.setZipCode(a.getZipCode());

        adressRepository.save(a);
        return a;
    }

    @Override
    public void deleteAdress(int id){
        adressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "Id", id));
        adressRepository.deleteById(id);
    }

    /*@Override
    public boolean selectExistByEmail(String email){
        return false;}*/

}
