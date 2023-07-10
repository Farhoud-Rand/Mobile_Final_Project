package com.example.final_project;

public class User {

    String Name;
    String Email;
    String Password;
    String Number;

    public User() {
    }

    public User(String name, String email, String password, String number) {
        Name = name;
        Email = email;
        Password = password;
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}