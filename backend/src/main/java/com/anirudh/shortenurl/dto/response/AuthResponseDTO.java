package com.anirudh.shortenurl.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDTO {
    private String message;
    private String userName;
    private String token;
}
