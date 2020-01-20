package com.lanstar.pesaplusdashboard.repository;

import com.lanstar.pesaplusdashboard.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
