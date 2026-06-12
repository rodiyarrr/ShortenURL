package com.anirudh.shortenurl.repository;

import com.anirudh.shortenurl.model.ShortLink;
import com.anirudh.shortenurl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ShortLinkRepository extends JpaRepository<ShortLink, UUID> {

    boolean existsByShortCode(String shortCode);

    // To handle null values from the DB
    Optional<ShortLink> findByShortCode(String shortCode);

}
