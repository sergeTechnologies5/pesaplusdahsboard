package com.lanstar.pesaplusdashboard.repository;

import com.lanstar.pesaplusdashboard.model.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.OptionalInt;

public interface OtpRepository extends JpaRepository<Otp, Long> {

    OptionalInt findByOtpCode(OptionalInt otp);
}
