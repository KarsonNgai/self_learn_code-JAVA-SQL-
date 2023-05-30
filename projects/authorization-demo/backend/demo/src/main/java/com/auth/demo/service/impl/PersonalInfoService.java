package com.auth.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.demo.model.User;
import com.auth.demo.repository.UserRepository;
import com.auth.demo.service.PersonalInfoServiceInterface;

@Service
public class PersonalInfoService implements PersonalInfoServiceInterface{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllRole() {
        return userRepository.findAll();
    }

    @Override
    public User getRoleById(Long id) {
        return userRepository.findById(id).orElse(new User());
    }
    
}
