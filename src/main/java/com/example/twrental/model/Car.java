package com.example.twrental.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id",nullable = false)
    private int car_id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "cost_per_day")
    private double cost_per_day;
    @Column(name = "seats", nullable = false)
    private int seats;
    @Column(name = "transmission", nullable = false)
    private String transmission; //Enum?
    @Column(name = "ac", nullable = false)
    private boolean ac;


    // Osäker vilken koppling
   /* @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    private List<Booking> bookings = new ArrayList<>();*/


    public Car(int car_id, String name, String model, double cost_per_day, int seats, String transmission, boolean ac) {
        this.car_id = car_id;
        this.name = name;
        this.model = model;
        this.cost_per_day = cost_per_day;
        this.seats = seats;
        this.transmission = transmission;
        this.ac = ac;

    }


    public Car() {

    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCost_per_day() {
        return cost_per_day;
    }

    public void setCost_per_day(double cost_per_day) {
        this.cost_per_day = cost_per_day;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public boolean isAc() {
        return ac;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }





}
