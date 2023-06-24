package com.example.ExpValMap.dto;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employeereq {
    @NotNull(message="name should not be null")
    private String name;
    @Email(message = "email should not be null")
    private String email;

    private String pno;
}
