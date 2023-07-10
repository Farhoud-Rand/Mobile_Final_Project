package com.example.final_project.Models;

import java.util.Date;

public class ReservationData {
    private String duration;
    private Date date;

    public ReservationData(String duration, Date date) {
        this.duration = duration;
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public Date getDate() {
        return date;
    }
}