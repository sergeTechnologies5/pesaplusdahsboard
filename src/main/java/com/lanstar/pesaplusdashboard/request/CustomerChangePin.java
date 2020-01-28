package com.lanstar.pesaplusdashboard.request;

public class CustomerChangePin {

    String pin;
    String phoneNumber;
    String id;

    public CustomerChangePin() {
    }

    public CustomerChangePin(String pin, String phoneNumber, String id) {
        this.pin = pin;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "pin='" + pin + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
