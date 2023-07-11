package com.example.final_project.Models;

public class User {
    private String email;
    private String name;
    private String password;
    private Boolean reserved;
    private Float total_bill;

    public User(String email, String name, String password, Boolean reserved, Float total_bill) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.reserved = reserved;
        this.total_bill = total_bill;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public Float getTotal_bill() {
        return total_bill;
    }

    public void setTotal_bill(Float total_bill) {
        this.total_bill = total_bill;
    }
}
