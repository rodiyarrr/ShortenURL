package com.anirudh.shortenurl.util;

import org.springframework.stereotype.Component;
import java.security.SecureRandom;

@Component
public class ShortURLGenerator {

    private static final String CHARACTERS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private static final int CODE_LENGTH = 7;

    private final SecureRandom random = new SecureRandom();

    public String generate() {
        StringBuilder shortCode=new StringBuilder(CODE_LENGTH);

        for (int i=0;i<CODE_LENGTH;i++){
            int index= random.nextInt(CHARACTERS.length());
            shortCode.append(CHARACTERS.charAt(index));
        }

        return shortCode.toString();
    }
}
