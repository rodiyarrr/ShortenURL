package com.anirudh.shortenurl.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class LinkResponseDTO {
    private String shareCode;
    private String userURL;
    private long clickCount;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
}
