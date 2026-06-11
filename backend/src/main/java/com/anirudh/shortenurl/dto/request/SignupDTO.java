package com.anirudh.shortenurl.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupDTO {
    @NotBlank(message = "Username required")
    private String userName;

    @NotBlank(message = "Email required")
    @Email(message = "Enter a valid email")
    private String email;

    @NotBlank(message = "Password required")
    private String password;
}
