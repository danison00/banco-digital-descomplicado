package com.dan.bancodigitaldescomplicado.infra.webSecurity;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dan.bancodigitaldescomplicado.infra.tokenJWT.TokenService;
import com.dan.bancodigitaldescomplicado.service.interfaces.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException, RuntimeException {
     
           String token = this.recoverToken(request);

           if(token != null){
                
                String username = tokenService.validateToken(token);
                
                if(username != null){
                    
                    UserDetails user = userService.loadUserByUsername(username);
                    var userAuthentication = new UsernamePasswordAuthenticationToken(username, user, user.getAuthorities());      
                    SecurityContextHolder.getContext().setAuthentication(userAuthentication);
                }
           }

           filterChain.doFilter(request, response);
        
    }
    
    protected String recoverToken(HttpServletRequest request){

        var authHeader = request.getHeader("Authorization");

        if(authHeader == null) return null;

        return authHeader.replace("Bearer ", "");
    }
}
