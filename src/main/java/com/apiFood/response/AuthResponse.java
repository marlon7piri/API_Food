package com.apiFood.response;

import com.apiFood.entities.user.USER_ROLE;
import lombok.Data;


@Data
public class AuthResponse {

    private String jwt;
    private String message;
    private USER_ROLE role;
}
