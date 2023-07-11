package com.example.final_project.Models;


public class HotelHall {
    int reservation_ID;
    int customer_ID;
    String start_Date;
    String start_Time;
    String end_Date;
    String end_Time;
    String purpose;
    String status;

    public HotelHall(int reservation_ID, int customer_ID, String start_Date, String start_Time, String end_Date, String end_Time, String purpose, String status) {
        this.reservation_ID = reservation_ID;
        this.customer_ID = customer_ID;
        this.start_Date = start_Date;
        this.start_Time = start_Time;
        this.end_Date = end_Date;
        this.end_Time = end_Time;
        this.purpose = purpose;
        this.status = status;
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

    public String getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(String start_Date) {
        this.start_Date = start_Date;
    }

    public String getStart_Time() {
        return start_Time;
    }

    public void setStart_Time(String start_Time) {
        this.start_Time = start_Time;
    }

    public String getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(String end_Date) {
        this.end_Date = end_Date;
    }

    public String getEnd_Time() {
        return end_Time;
    }

    public void setEnd_Time(String end_Time) {
        this.end_Time = end_Time;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
