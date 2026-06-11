package com.anirudh.shortenurl.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ShortenResponseDTO {
    private String shortenedURL;
    private LocalDateTime expiresAt;
}
