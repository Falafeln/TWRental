package com.example.twrental.VO;

import com.example.twrental.model.Booking;

public class ResponseTemplateVO {

    private Booking booking;
    private Exchange exchange;

    public ResponseTemplateVO() {
    }

    public ResponseTemplateVO(Booking booking, Exchange exchange) {
        this.booking = booking;
        this.exchange = exchange;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }
}
