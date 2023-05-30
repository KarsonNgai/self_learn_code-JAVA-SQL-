package com.auth.demo.service;

import java.util.List;

import com.auth.demo.model.User;

public interface PersonalInfoServiceInterface {
    List<User> getAllRole();

    User getRoleById(Long id);
}
