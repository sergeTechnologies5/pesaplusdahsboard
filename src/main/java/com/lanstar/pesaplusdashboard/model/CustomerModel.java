package com.lanstar.pesaplusdashboard.model;

public class CustomerModel {
    CustomerInfo customerInfo;
    MnoInfo mnoInfo;
    SaccoInfo saccoInfo;

    // Getter Methods

    // Setter Methods

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public MnoInfo getMnoInfo() {
        return mnoInfo;
    }

    public void setMnoInfo(MnoInfo mnoInfo) {
        this.mnoInfo = mnoInfo;
    }

    public SaccoInfo getSaccoInfo() {
        return saccoInfo;
    }

    public void setSaccoInfo(SaccoInfo saccoInfo) {
        this.saccoInfo = saccoInfo;
    }

    @Override
    public String toString() {
        return "{" +
                "customerInfo=" + customerInfo +
                ", MnoInfoObject=" + mnoInfo +
                ", SaccoInfoObject=" + saccoInfo +
                '}';
    }
}


