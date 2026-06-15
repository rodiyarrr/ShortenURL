package com.anirudh.shortenurl.config;

import com.anirudh.shortenurl.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Configuration
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            String authHeader=request.getHeader("Authorization");

            if(authHeader!=null && authHeader.startsWith("Bearer ")){
                String token=authHeader.substring(7);

                if(jwtService.validateToken(token)){
                    String userName= jwtService.extractUserName(token);

                    UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(userName,null,new ArrayList<>());

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
            filterChain.doFilter(request,response);
    }
}
