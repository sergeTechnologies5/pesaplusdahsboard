package com.lanstar.pesaplusdashboard.payload;

import java.util.List;

public class User {
    private String username;
    private String token;

    private List<String> roles;

    public User(String username, String token, List<String> roles) {
        this.username = username;
        this.token = token;
        this.roles=roles;
    }

    public User() {

    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", roles=" + roles +
                '}';
    }
}
