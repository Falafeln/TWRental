package com.example.twrental.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "adress")
public class Adress {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "adress_id", nullable = false)
  private int adress_id;
@Column(name = "street", nullable = false)
  private String street;
@Column(name = "street_number", nullable = false)
  private String street_number;
@Column(name = "district", nullable = false)
  private String district;
@Column(name = "country", nullable = false)
  private String country;
@Column(name = "zip_code",nullable = false)
private String zipCode;

@OneToMany
private List<Customer>customers = new ArrayList<>();


    public Adress() {
    }

    public Adress(String street, String street_number, String district, String country, String zipCode) {

        this.street = street;
        this.street_number = street_number;
        this.district = district;
        this.country = country;
        this.zipCode = zipCode;

    }

    /*
          Getters och Setters
           */
    public int getAdress_id() {
        return adress_id;
    }

    public void setAdress_id(int adress_id) {
        this.adress_id = adress_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
