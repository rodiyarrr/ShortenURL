package com.anirudh.shortenurl.controller;

import com.anirudh.shortenurl.service.ShortenURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;

@RestController
public class GetOriginalURLController {

    @Autowired
    public ShortenURLService shortenURLService;

    @GetMapping("/api/{shortCode}")
    public ResponseEntity<String> getOriginalURL(@PathVariable String shortCode){
        String originalURL=shortenURLService.getOriginalURL(shortCode);

        return ResponseEntity.ok(originalURL);
    }
}
