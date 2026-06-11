package com.anirudh.shortenurl.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    @NotBlank(message = "Username or Email required")
    private String identifier;

    @NotBlank(message = "Password required")
    private String password;

}
