package com.anirudh.shortenurl.service;

import com.anirudh.shortenurl.dto.request.LoginDTO;
import com.anirudh.shortenurl.dto.request.SignupDTO;
import com.anirudh.shortenurl.dto.response.AuthResponseDTO;
import com.anirudh.shortenurl.exceptions.DuplicateUserException;
import com.anirudh.shortenurl.exceptions.InvalidUserException;
import com.anirudh.shortenurl.model.Role;
import com.anirudh.shortenurl.model.User;
import com.anirudh.shortenurl.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public BCryptPasswordEncoder passwordEncoder;

    public AuthResponseDTO signupService(@Valid SignupDTO signupDTO){
        if (userRepository.existsByUserName(signupDTO.getUserName())){
            throw new DuplicateUserException("Username already taken");
        }
        if (userRepository.existsByEmail(signupDTO.getEmail())) {
            throw new DuplicateUserException("Email already registered");
        }

        User user=new User();

        user.setUserName(signupDTO.getUserName());

        user.setEmail(signupDTO.getEmail());
        user.setPasswordHash(passwordEncoder.encode(signupDTO.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);

        AuthResponseDTO responseDTO=new AuthResponseDTO();
        responseDTO.setMessage("User Registered successfully");
        responseDTO.setUserName(user.getUserName());

        return responseDTO;

    }

    public AuthResponseDTO loginService(@Valid LoginDTO loginDTO) {
        // identifier se user dhundo — pehle username try karo, phir email
        User user = userRepository.findByUserName(loginDTO.getIdentifier())
                .or(() -> userRepository.findByEmail(loginDTO.getIdentifier()))
                .orElseThrow(() -> new InvalidUserException("User not found"));

        //to verify password
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPasswordHash())) {
            throw new InvalidUserException("Invalid password");
        }

        AuthResponseDTO response = new AuthResponseDTO();
        response.setMessage("Login successful");
        response.setUserName(user.getUserName());

        return response;
    }
}
