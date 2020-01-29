package com.lanstar.pesaplusdashboard.model;

public class SystemUser {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String nationalId;
    private String passportNo;
    private String isActive;
    private String isStaff;
    private String isSuperuser;
    private String roleName;

    public SystemUser() {
    }

    public SystemUser(String firstName, String lastName, String phoneNumber, String email, String nationalId, String passportNo, String isActive, String isStaff, String isSuperuser, String roleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.nationalId = nationalId;
        this.passportNo = passportNo;
        this.isActive = isActive;
        this.isStaff = isStaff;
        this.isSuperuser = isSuperuser;
        this.roleName = roleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(String isStaff) {
        this.isStaff = isStaff;
    }

    public String getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(String isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    @Override
    public String toString() {
        return "SystemUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", passportNo='" + passportNo + '\'' +
                ", isActive='" + isActive + '\'' +
                ", isStaff='" + isStaff + '\'' +
                ", isSuperuser='" + isSuperuser + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
