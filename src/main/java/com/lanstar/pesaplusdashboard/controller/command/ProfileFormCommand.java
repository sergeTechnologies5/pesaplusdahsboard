package com.lanstar.pesaplusdashboard.controller.command;

import lombok.Data;
import lombok.experimental.Accessors;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by Arpit Khandelwal.
 */
@Data
@Accessors(chain = true)
public class ProfileFormCommand {
    @NotBlank
    @Size(min = 1, max = 40)
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Size(min = 5, max = 13)
    private String mobileNumber;
}
