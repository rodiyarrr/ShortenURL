package com.anirudh.shortenurl.repository;

import com.anirudh.shortenurl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    
}
