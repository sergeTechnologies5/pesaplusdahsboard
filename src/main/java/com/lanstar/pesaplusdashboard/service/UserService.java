package com.lanstar.pesaplusdashboard.service;

import com.lanstar.pesaplusdashboard.model.Users;

import java.util.List;

public interface UserService {

    Users save(Users user);
    List<Users> findAll();
    void delete(long id);
}