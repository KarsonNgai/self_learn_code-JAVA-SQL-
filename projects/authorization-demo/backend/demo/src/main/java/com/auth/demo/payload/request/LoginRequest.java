package com.auth.demo.payload.request;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String username;

    private String password;
}
