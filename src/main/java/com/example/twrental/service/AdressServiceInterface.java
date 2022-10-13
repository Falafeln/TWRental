package com.example.twrental.service;

import com.example.twrental.model.Adress;

import java.util.List;

public interface AdressServiceInterface {
    Adress saveAdress(Adress adress);
    List<Adress>getAllAdress();
    Adress getAdressById(int id);
    Adress updateAdress(Adress adress, int id);
    void deleteAdress(int id);

    //boolean


}
