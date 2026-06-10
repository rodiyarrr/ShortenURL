package com.anirudh.shortenurl.controller;

import com.anirudh.shortenurl.dto.AuthResponseDTO;
import com.anirudh.shortenurl.dto.SignupDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class SignupController {

    @PostMapping("/signup")
    public AuthResponseDTO signup(@RequestBody SignupDTO signupDTO){
        return new AuthResponseDTO();
    }

}
