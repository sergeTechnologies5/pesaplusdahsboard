package com.lanstar.pesaplusdashboard.payload.createUser;

public class UserInfo {
    private String email;
    private String firstName;
    private String isActive;
    private String isStaff;
    private String isSuperuser;
    private String lastName;
    private String password;
    private String username;
    private String roleName;


    // Getter Methods

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getIsStaff() {
        return isStaff;
    }

    public String getIsSuperuser() {
        return isSuperuser;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getRoleName() {
        return roleName;
    }

    // Setter Methods

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public void setIsStaff(String isStaff) {
        this.isStaff = isStaff;
    }

    public void setIsSuperuser(String isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
