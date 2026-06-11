package com.anirudh.shortenurl.controller;

import com.anirudh.shortenurl.dto.request.ShortenRequestDTO;
import com.anirudh.shortenurl.dto.response.ShortenResponseDTO;
import com.anirudh.shortenurl.service.ShortenURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shorten")
public class ShortenURLController {

    @Autowired
    public ShortenURLService shortenURLService;

    public ShortenResponseDTO shortenURL(@RequestBody ShortenRequestDTO request){
        return shortenURLService.shorten(request);
    }
}
