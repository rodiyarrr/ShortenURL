package com.anirudh.shortenurl.exceptions;

public class URLExpiredException extends RuntimeException{
    public URLExpiredException(String message) {
        super(message);
    }
}
