package com.lanstar.pesaplusdashboard.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Customer implements Serializable {
    private String firstName;
    private String secondName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String nationalId;
    private BigDecimal advanceLimit;
    private BigDecimal withdrawalLimit;

    public Customer() {
    }

    public Customer(String firstName, String secondName, String lastName, String phoneNumber, String email, String nationalId, BigDecimal advanceLimit, BigDecimal withdrawalLimit) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.nationalId = nationalId;
        this.advanceLimit = advanceLimit;
        this.withdrawalLimit = withdrawalLimit;
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

    public BigDecimal getAdvanceLimit() {
        return advanceLimit;
    }

    public void setAdvanceLimit(BigDecimal advanceLimit) {
        this.advanceLimit = advanceLimit;
    }

    public BigDecimal getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(BigDecimal withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }
}
