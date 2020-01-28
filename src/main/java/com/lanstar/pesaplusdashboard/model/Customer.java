package com.lanstar.pesaplusdashboard.model;

import com.lanstar.pesaplusdashboard.Response.CustomerMO;
import com.lanstar.pesaplusdashboard.Response.SaccoResponse;

import java.io.Serializable;
import java.math.BigDecimal;

public class Customer implements Serializable {
    private String firstName;
    private String secondName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String nationalId;
    private Integer advanceLimit;
    private Integer withdrawalLimit;

    private Long  saccoID;
    private Long moID;

    public Customer() {
    }

    public Customer(String firstName, String secondName, String lastName, String phoneNumber, String email, String nationalId) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.nationalId = nationalId;

    }


    public Long getSaccoID() {
        return saccoID;
    }

    public void setSaccoID(Long saccoID) {
        this.saccoID = saccoID;
    }

    public Long getMoID() {
        return moID;
    }

    public void setMoID(Long moID) {
        this.moID = moID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Integer getAdvanceLimit() {
        return advanceLimit;
    }

    public void setAdvanceLimit(Integer advanceLimit) {
        this.advanceLimit = advanceLimit;
    }

    public Integer getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(Integer withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", advanceLimit=" + advanceLimit +
                ", withdrawalLimit=" + withdrawalLimit +
                ", saccoID=" + saccoID +
                ", moID=" + moID +
                '}';
    }
}
