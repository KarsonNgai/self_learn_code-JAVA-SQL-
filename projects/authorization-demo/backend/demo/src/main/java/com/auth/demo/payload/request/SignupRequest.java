package com.auth.demo.payload.request;

import java.util.Set;

import lombok.Getter;

@Getter
public class SignupRequest {
    String username;

    String email;

    String password;

    Set<String> role;
}
