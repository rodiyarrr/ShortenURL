package com.anirudh.shortenurl.controller;

import com.anirudh.shortenurl.dto.request.ShortenRequestDTO;
import com.anirudh.shortenurl.dto.response.ShortenResponseDTO;
import com.anirudh.shortenurl.service.ShortenURLService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shorten")
public class ShortenURLController {

    @Autowired
    public ShortenURLService shortenURLService;

    @PostMapping
    public ShortenResponseDTO shortenURL(@Valid @RequestBody ShortenRequestDTO request){
        String userName=null;
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()
                && !(authentication.getPrincipal() instanceof String principal
                && principal.equals("anonymousUser"))) {
            userName = (String) authentication.getPrincipal();
        }

        return shortenURLService.shorten(request,userName);
    }

}
