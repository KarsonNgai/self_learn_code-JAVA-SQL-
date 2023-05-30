package com.auth.demo.payload.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserInfoResponse {
    private Long id;
    private String username;
    private String email;
    private List<String> role;
}
