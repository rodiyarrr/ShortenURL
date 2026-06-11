package com.anirudh.shortenurl.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShortenRequestDTO {

    @NotBlank(message = "Enter URL to shorten")
    private String userURL;

}
