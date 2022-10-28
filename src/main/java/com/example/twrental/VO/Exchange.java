package com.example.twrental.VO;

public class Exchange {
    private int exchangeId;
    private double euro;
    private double sek;
    private static double exchangeRate = 11.6572;

    private int days;

    private double totalEuro;

    private double totalSEK;

    private int bookingId;
    public Exchange() {
    }


    public Exchange(int exchangeId, double euro, double sek, int days, double totalEuro, double totalSEK, int bookingId) {
        this.exchangeId = exchangeId;
        this.euro = euro;
        this.sek = sek;
        this.days = days;
        this.totalEuro = totalEuro;
        this.totalSEK = totalSEK;
        this.bookingId = bookingId;
    }

    public double getTotalSEK() {
        return totalSEK;
    }

    public void setTotalSEK(double totalSEK) {
        this.totalSEK = totalSEK;
    }

    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
    }

    public double getEuro() {
        return euro = sek/exchangeRate;
    }

    public void setEuro(double euro) {
        this.euro = euro;
    }

    public double getSek() {
        return sek;
    }

    public void setSek(double sek) {
        this.sek = sek;
    }

    public static double getExchangeRate() {
        return exchangeRate;
    }

    public static void setExchangeRate(double exchangeRate) {
        Exchange.exchangeRate = exchangeRate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getTotalEuro() {
        return totalEuro =euro*days;
    }

    public void setTotalEuro(double totalEuro) {
        this.totalEuro = totalEuro;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
