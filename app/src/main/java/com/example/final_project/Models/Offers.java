package com.example.final_project.Models;

public class Offers {
    int offer_ID;
    String offer_Name;
    String description;
    String start_Date;
    String end_Date;
    float discount;
    int picture;

    public Offers(int offer_ID, String offer_Name, String description, String start_Date, String end_Date, int discount, int picture) {
        this.offer_ID = offer_ID;
        this.offer_Name = offer_Name;
        this.description = description;
        this.start_Date = start_Date;
        this.end_Date = end_Date;
        this.discount = discount;
        this.picture = picture;
    }

    public int getOffer_ID() {
        return offer_ID;
    }

    public void setOffer_ID(int offer_ID) {
        this.offer_ID = offer_ID;
    }

    public String getOffer_Name() {
        return offer_Name;
    }

    public void setOffer_Name(String offer_Name) {
        this.offer_Name = offer_Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(String start_Date) {
        this.start_Date = start_Date;
    }

    public String getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(String end_Date) {
        this.end_Date = end_Date;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
