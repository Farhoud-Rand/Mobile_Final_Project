package com.example.final_project.Models;


public class MassageReservation {
    int reservation_ID;
    int customer_ID;
    String massage_Type;
    String reservation_Date;
    String reservation_Time;
    float duration;
    String status;
    float price;

    public MassageReservation(int reservation_ID, int customer_ID, String massage_Type, String reservation_Date, String reservation_Time, float duration, String status, float price) {
        this.reservation_ID = reservation_ID;
        this.customer_ID = customer_ID;
        this.massage_Type = massage_Type;
        this.reservation_Date = reservation_Date;
        this.reservation_Time = reservation_Time;
        this.duration = duration;
        this.status = status;
        this.price = price;
    }

    public int getReservation_ID() {
        return reservation_ID;
    }

    public void setReservation_ID(int reservation_ID) {
        this.reservation_ID = reservation_ID;
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getMassage_Type() {
        return massage_Type;
    }

    public void setMassage_Type(String massage_Type) {
        this.massage_Type = massage_Type;
    }

    public String getReservation_Date() {
        return reservation_Date;
    }

    public void setReservation_Date(String reservation_Date) {
        this.reservation_Date = reservation_Date;
    }

    public String getReservation_Time() {
        return reservation_Time;
    }

    public void setReservation_Time(String reservation_Time) {
        this.reservation_Time = reservation_Time;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
