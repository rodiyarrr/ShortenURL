package com.anirudh.shortenurl.repository;

import com.anirudh.shortenurl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);

    Optional<User> findByUserName(String userName);
    Optional<User> findByEmail(String email);

}
