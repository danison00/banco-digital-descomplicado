package com.dan.bancodigitaldescomplicado.web.apiControllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dan.bancodigitaldescomplicado.infra.tokenJWT.TokenService;
import com.dan.bancodigitaldescomplicado.model.dto.LoginDto;
import com.dan.bancodigitaldescomplicado.model.dto.LoginResponseDto;
import com.dan.bancodigitaldescomplicado.model.entity.User;
import com.dan.bancodigitaldescomplicado.service.interfaces.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api-public")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto user, HttpServletResponse response) {


        if (!userService.usernameAlreadyExists(user.username()))

            throw new RuntimeException("Usuário inexistente ou senha inválida!");

        var usernamePassword = new UsernamePasswordAuthenticationToken(user.username(), user.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((User) auth.getPrincipal());

        Cookie cookie = new Cookie("token-acess", token);
        cookie.setPath("/");
        cookie.setMaxAge(60);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        return ResponseEntity.ok().body(new LoginResponseDto(token));
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) throws IOException {

        Cookie cookie = new Cookie("token-acess", "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.sendRedirect("/login");

        return ResponseEntity.ok().build();
    }
}
