package com.anirudh.shortenurl.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Size(min = 3,max = 30)
    @Column(unique = true,nullable = false)
    private String userName;

    @NotBlank
    @Column(nullable = false)
    private String passwordHash;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;
}
