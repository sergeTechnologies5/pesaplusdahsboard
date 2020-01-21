package com.lanstar.pesaplusdashboard.model;

public class CustomerInfo {
    private String firstName;
    private String secondName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String nationalId;
    private Integer advanceLimit;
    private Integer withdrawalLimit;


    // Getter Methods

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getNationalId() {
        return nationalId;
    }

    public Integer getAdvanceLimit() {
        return advanceLimit;
    }

    public Integer getWithdrawalLimit() {
        return withdrawalLimit;
    }

    // Setter Methods

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public void setAdvanceLimit(Integer advanceLimit) {
        this.advanceLimit = advanceLimit;
    }

    public void setWithdrawalLimit(Integer withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", advanceLimit=" + advanceLimit +
                ", withdrawalLimit=" + withdrawalLimit +
                '}';
    }
}
