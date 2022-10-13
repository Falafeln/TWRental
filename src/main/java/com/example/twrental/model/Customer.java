package com.example.twrental.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id", nullable = false)
    private int cust_id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "pwd", nullable = false)
    private String pwd;
    @Column(name = "first_name", nullable = false)
    private String first_name;
    @Column(name = "last_name", nullable = false)
    private String last_name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "adress_id", referencedColumnName = "adress_id")
    private Adress adress;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    //Dubbelkolla hur jag ska skriva denna, tog från tidigare projekt nu
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Booking> bookings = new ArrayList<>();

    public Customer() {
    }

    public Customer(int cust_id, String username, String pwd, String first_name, String last_name, Adress adress, String phone, String email, List<Booking> bookings) {
        this.cust_id = cust_id;
        this.username = username;
        this.pwd = pwd;
        this.first_name = first_name;
        this.last_name = last_name;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
        this.bookings = bookings;
    }

    public Customer(int cust_id, List<Booking> bookings) {
        this.cust_id = cust_id;
        this.bookings = bookings;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
