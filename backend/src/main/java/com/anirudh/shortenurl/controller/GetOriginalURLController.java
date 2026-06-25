package com.anirudh.shortenurl.controller;

import com.anirudh.shortenurl.dto.response.LinkResponseDTO;
import com.anirudh.shortenurl.model.ShortLink;
import com.anirudh.shortenurl.service.ShortenURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class GetOriginalURLController {

    @Autowired
    public ShortenURLService shortenURLService;

    @GetMapping("/api/{shortCode}")
    public ResponseEntity<String> getOriginalURL(@PathVariable String shortCode){
        String originalURL=shortenURLService.getOriginalURL(shortCode);

        return ResponseEntity.ok(originalURL);
    }

    @GetMapping("/api/links")
    public ResponseEntity<List<LinkResponseDTO>>  getAllLinks(){
        String userName= (String) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        List<LinkResponseDTO> allLinks=shortenURLService.getAllLinks(userName);
        return ResponseEntity.ok(allLinks);
    }

    @DeleteMapping("/api/delete/{shortCode}")
    public ResponseEntity<String> deleteLink(@PathVariable String shortCode){
        shortenURLService.deleteLink(shortCode);

        return ResponseEntity.ok("Link Successfully Deleted");
    }
}
