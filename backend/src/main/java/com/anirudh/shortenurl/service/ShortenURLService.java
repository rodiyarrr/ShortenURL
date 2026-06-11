package com.anirudh.shortenurl.service;

import com.anirudh.shortenurl.dto.request.ShortenRequestDTO;
import com.anirudh.shortenurl.dto.response.ShortenResponseDTO;
import com.anirudh.shortenurl.repository.ShortLinkRepository;
import com.anirudh.shortenurl.util.ShortURLGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortenURLService {

    @Autowired
    public ShortLinkRepository repository;
    @Autowired
    public ShortURLGenerator generator;

    public ShortenResponseDTO shorten(ShortenRequestDTO request) {

    }
}
