package com.anirudh.shortenurl.service;

import com.anirudh.shortenurl.dto.request.ShortenRequestDTO;
import com.anirudh.shortenurl.dto.response.ShortenResponseDTO;
import com.anirudh.shortenurl.exceptions.InvalidURLException;
import com.anirudh.shortenurl.exceptions.URLExpiredException;
import com.anirudh.shortenurl.model.ShortLink;
import com.anirudh.shortenurl.model.User;
import com.anirudh.shortenurl.repository.ShortLinkRepository;
import com.anirudh.shortenurl.repository.UserRepository;
import com.anirudh.shortenurl.util.ShortURLGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ShortenURLService {

    //To import this value from application.properties
    @Value("${app.base-url}")
    private String baseURL;

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public ShortLinkRepository repository;
    @Autowired
    public AuthService authService;
    @Autowired
    public ShortURLGenerator generator;

    public ShortenResponseDTO shorten(ShortenRequestDTO request,String userName) {

        String shortCode;

        //Generate Short Code
        do {
            shortCode=generator.generate();
        }while (repository.existsByShortCode(shortCode));
        //jab tak aisa short-code exist krta hai DB mai, naya code banate raho jisse duplicates na ho

        ShortLink shortLink=new ShortLink();

        shortLink.setUserURL(request.getUserURL());
        shortLink.setShortCode(shortCode);
        // DB mai shortCode hi save karte bas not the whole URL, since aage jake koi Domain change ho toh ek jagah hi hojaye changes
        shortLink.setCreatedAt(LocalDateTime.now());

        // Guest ya registered user
        if (userName == null) {
            User guest = authService.createGuestUser();
            shortLink.setUser(guest);
            shortLink.setExpiresAt(LocalDateTime.now().plusHours(24));
        } else {
            userRepository.findByUserName(userName)
                    .ifPresent(shortLink::setUser);
            shortLink.setExpiresAt(null);
        }

        //Save to DB
        repository.save(shortLink);

        ShortenResponseDTO responseDTO=new ShortenResponseDTO();
        responseDTO.setShortenedURL(baseURL+"/"+shortCode);
        responseDTO.setExpiresAt(shortLink.getExpiresAt());

        return responseDTO;
    }

    public String getOriginalURL(String shortCode) {
        ShortLink shortLink = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new InvalidURLException("Invalid URL"));

        if (!shortLink.isActive()){
            throw new URLExpiredException("Short URL is inactive");
        }

        if (shortLink.getExpiresAt() != null
                && shortLink.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new URLExpiredException("Short URL has expired");
        }

        shortLink.setClickCount(shortLink.getClickCount()+1);
        repository.save(shortLink);

        return shortLink.getUserURL();
    }

}
