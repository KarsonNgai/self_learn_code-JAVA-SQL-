package com.auth.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.demo.model.ERole;
import com.auth.demo.model.Role;
import com.auth.demo.model.User;
import com.auth.demo.payload.request.LoginRequest;
import com.auth.demo.payload.request.SignupRequest;
import com.auth.demo.payload.response.MessageResponse;
import com.auth.demo.payload.response.UserInfoResponse;
import com.auth.demo.repository.RoleRepository;
import com.auth.demo.repository.UserRepository;
import com.auth.demo.security.jwt_config.JwtUtils;
import com.auth.demo.security.jwt_service.UserDetailsImpl;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticationUser(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                                .map((item->item.getAuthority()))
                                .collect(Collectors.toList());
        
        return ResponseEntity.ok()
                                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
        //because of http only in localhost, js cannot get the data and set-cookie would not be setted in window.cookie in frontend, 
                                .header("x-auth-token", jwtCookie.toString())
        //we have to set another header which would disclose to get in frontend
                                .header("access-control-expose-headers", "x-auth-token")
                                .body(new UserInfoResponse(userDetails.getId(),
                                                            userDetails.getUsername(),
                                                            userDetails.getEmail(),
                                                            roles));
    }

    @PostMapping(value = "/signup", produces = "application/json")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest){
        if(userRepository.existsByUsername(signupRequest.getUsername())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken"));
        }

        if(userRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken"));
        }

        //create new user's account
        User user = new User(signupRequest.getUsername(), signupRequest.getEmail(), encoder.encode(signupRequest.getPassword()));

        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();
        
        if(Objects.isNull(strRoles) || strRoles.size()==0){
            //no role, or aka not login
            Role userRole = roleRepository.findByName(ERole.ROLE_USER) 
                            .orElseThrow(()->new RuntimeException("Error: Role is not found"));
            roles.add(userRole);
        } else{
            strRoles.forEach(role->{
                ERole roleCode;
                switch(role.toLowerCase()){
                    case "admin":
                        roleCode = ERole.ROLE_ADMIN;
                        break;
                    case "mod":
                        roleCode = ERole.ROLE_MODERATOR;
                        break;
                    default:
                        roleCode = ERole.ROLE_USER;
                }
                Role adminRole = roleRepository.findByName(roleCode)
                                    .orElseThrow(()->new RuntimeException("Error: Role is not found"));           
                roles.add(adminRole);
            });
        }

        user.setRoles(roles);
        userRepository.saveAndFlush(user);
        return ResponseEntity.ok().body(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser(){
        ResponseCookie jwtCookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                                .header("x-auth-token", jwtCookie.toString())
                                .header("access-control-expose-headers", "x-auth-token") 
                                .body(new MessageResponse("You've been signed out!"));
    }
    
    @GetMapping("/connect")
    public String checkConnect(){
        return "connected";
    }
}
