package com.anirudh.shortenurl.controller;

import com.anirudh.shortenurl.dto.response.AuthResponseDTO;
import com.anirudh.shortenurl.dto.request.LoginDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @PostMapping("/login")
    public AuthResponseDTO login(@Valid @RequestBody LoginDTO loginDTO){

        return new AuthResponseDTO();
    }
}
