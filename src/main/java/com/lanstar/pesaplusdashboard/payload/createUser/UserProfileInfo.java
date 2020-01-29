package com.lanstar.pesaplusdashboard.payload.createUser;

public class UserProfileInfo {
    private String admin;
    private String apiUser;
    private String email;
    private String nationalId;
    private String passportNo;
    private String phoneNumber;
    private String saccoAdmin;


    // Getter Methods

    public String getAdmin() {
        return admin;
    }

    public String getApiUser() {
        return apiUser;
    }

    public String getEmail() {
        return email;
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSaccoAdmin() {
        return saccoAdmin;
    }

    // Setter Methods

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public void setApiUser(String apiUser) {
        this.apiUser = apiUser;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSaccoAdmin(String saccoAdmin) {
        this.saccoAdmin = saccoAdmin;
    }
}
