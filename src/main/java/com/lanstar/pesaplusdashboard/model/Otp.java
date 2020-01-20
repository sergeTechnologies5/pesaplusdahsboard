package com.lanstar.pesaplusdashboard.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Otp extends AbstractModel<Long>  {

    @Column(nullable = false, length = 40)
    private String jwt;
    @Column(nullable = false, length = 40)
    private String otpCode;

}
