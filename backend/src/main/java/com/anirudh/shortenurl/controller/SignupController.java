package com.anirudh.shortenurl.controller;

import com.anirudh.shortenurl.dto.response.AuthResponseDTO;
import com.anirudh.shortenurl.dto.request.SignupDTO;
import com.anirudh.shortenurl.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class SignupController {
    @Autowired
    public AuthService authService;
    @PostMapping("/signup")
    public AuthResponseDTO signup(@Valid @RequestBody SignupDTO signupDTO){

        return authService.signupService(signupDTO);
    }

}
