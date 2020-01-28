package com.lanstar.pesaplusdashboard.Response;

import com.google.gson.annotations.SerializedName;

public class CustomerMO {
    Long id;
    String operatorName;
    String phoneNumber;
    String serviceName;

    public CustomerMO(Long id, String operatorName, String phoneNumber, String serviceName) {
        this.id = id;
        this.operatorName = operatorName;
        this.phoneNumber = phoneNumber;
        this.serviceName = serviceName;
    }

    public CustomerMO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
