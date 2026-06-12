package com.anirudh.shortenurl.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;


    @Size(min = 3,max = 30)
    @Column(unique = true,nullable = false)
    private String userName;

    private Role role;

    @NotBlank
    @Column(nullable = false)
    private String passwordHash;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;
}
