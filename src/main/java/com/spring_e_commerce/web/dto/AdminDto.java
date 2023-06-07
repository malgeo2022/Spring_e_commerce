package com.spring_e_commerce.web.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {

    @Size(min = 3, max = 10, message = "Invalid first name !")
    private String firstName;


    @Size(min = 3, max = 10, message = "Invalid last name !")
    private String lastName;

    private String username;

    @Size(min = 5, max = 15, message = "Invalid password !")
    private String password;

    private String repeatPassword;


}
