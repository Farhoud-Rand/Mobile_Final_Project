package com.example.final_project.Models;


public class Rooms {
    int room_ID;
    String type;
    int capacity;
    int price;
    String description;
    int floor;
    String reservations;
    String status;

    public Rooms() {
    }

    public Rooms(int room_ID, String type, int capacity, int price, String description, int floor, String reservations, String status) {
        this.room_ID = room_ID;
        this.type = type;
        this.capacity = capacity;
        this.price = price;
        this.description = description;
        this.floor = floor;
        this.reservations = reservations;
        this.status = status;
    }

    public int getRoom_ID() {
        return room_ID;
    }

    public void setRoom_ID(int room_ID) {
        this.room_ID = room_ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getReservations() {
        return reservations;
    }

    public void setReservations(String reservations) {
        this.reservations = reservations;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
