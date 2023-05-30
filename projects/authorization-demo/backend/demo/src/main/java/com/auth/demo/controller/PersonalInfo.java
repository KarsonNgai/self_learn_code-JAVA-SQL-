package com.auth.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.demo.model.User;
import com.auth.demo.payload.response.ApiResponse;
import com.auth.demo.service.PersonalInfoServiceInterface;

@RestController
@RequestMapping(value = "/api/personalInfo")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600, allowCredentials = "true")
public class PersonalInfo {

    @Autowired
    PersonalInfoServiceInterface personalInfoService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/user")
    public ResponseEntity<?> getAllRole(){
        List<User> users = personalInfoService.getAllRole();
        return ResponseEntity.ok().body(new ApiResponse<>(users));
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<?> getRoleById(@PathVariable(value = "userId") Long userId){
        User user = personalInfoService.getRoleById(userId);
        return ResponseEntity.ok().body(new ApiResponse<>(user));
    }
}
