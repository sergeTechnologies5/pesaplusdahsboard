package com.lanstar.pesaplusdashboard.payload.createUser;

public class CreateUser {
    UserInfo userInfo;
    UserProfileInfo userProfileInfo;
    SaccoInfo saccoInfo;
    // Getter Methods

    public CreateUser() {
    }

    public CreateUser(UserInfo userInfo, UserProfileInfo userProfileInfo, SaccoInfo saccoInfo) {
        this.userInfo = userInfo;
        this.userProfileInfo = userProfileInfo;
        this.saccoInfo = saccoInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserProfileInfo getUserProfileInfo() {
        return userProfileInfo;
    }

    public void setUserProfileInfo(UserProfileInfo userProfileInfo) {
        this.userProfileInfo = userProfileInfo;
    }

    public SaccoInfo getSaccoInfo() {
        return saccoInfo;
    }

    public void setSaccoInfo(SaccoInfo saccoInfo) {
        this.saccoInfo = saccoInfo;
    }
}

