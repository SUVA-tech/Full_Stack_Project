package com.eventwave.controller;

import com.eventwave.dto.RegistrationRequest;
import com.eventwave.dto.UserProfileUpdateRequest;
import com.eventwave.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegistrationRequest request) {
        return userService.registerUser(request);
    }
    
    @PutMapping("/profile/update/{email}")
    public String updateProfile(@PathVariable String email, @RequestBody UserProfileUpdateRequest request) {
        return userService.updateUserProfile(email, request);
    }

}
