package com.anirudh.shortenurl.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "short_links")
public class ShortLink {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String userURL;

    @NotBlank
    @Column(nullable = false,unique = true)
    private String shortCode;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userName", nullable = true)
    private User user;

    @Column(nullable = false)
    private long clickCount=0;

    @Column(nullable = false)
    private boolean isActive=true;

    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
}
