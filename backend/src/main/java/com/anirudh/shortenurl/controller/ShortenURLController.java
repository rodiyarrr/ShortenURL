package com.anirudh.shortenurl.controller;

import com.anirudh.shortenurl.dto.request.ShortenRequestDTO;
import com.anirudh.shortenurl.dto.response.ShortenResponseDTO;
import com.anirudh.shortenurl.service.ShortenURLService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shorten")
public class ShortenURLController {

    @Autowired
    public ShortenURLService shortenURLService;

    @PostMapping
    public ShortenResponseDTO shortenURL(@Valid @RequestBody ShortenRequestDTO request){
        return shortenURLService.shorten(request,null);
    }

}
