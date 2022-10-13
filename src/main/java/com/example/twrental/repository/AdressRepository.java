package com.example.twrental.repository;

import com.example.twrental.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdressRepository extends JpaRepository<Adress, Integer> {

    List<Adress>findAdressByStreetOrderByDistrictAsc(String adress);
    List<Adress>findAdressByStreetOrderByDistrictDesc(String adress);
}
