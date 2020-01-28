package com.lanstar.pesaplusdashboard.Response;

public class CustomerR {
    private String customerStatus ;
    private String customerFirstName;
    private String customerLastName;
    private String id;
    private String customerPhoneNumber;
    private String customerSaccoID;

    private String isRegistrationComplete;

    public CustomerR(String customerStatus, String customerFirstName, String customerLastName, String id, String customerPhoneNumber, String customerSaccoID, String isRegistrationComplete) {
        this.customerStatus = customerStatus;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.id = id;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerSaccoID = customerSaccoID;
        this.isRegistrationComplete = isRegistrationComplete;
    }

    public CustomerR() {
    }



    public String getIsRegistrationComplete() {
        return isRegistrationComplete;
    }

    public void setIsRegistrationComplete(String isRegistrationComplete) {
        this.isRegistrationComplete = isRegistrationComplete;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerSaccoID() {
        return customerSaccoID;
    }

    public void setCustomerSaccoID(String customerSaccoID) {
        this.customerSaccoID = customerSaccoID;
    }
}
