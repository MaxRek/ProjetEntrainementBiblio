package com.example.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.JwtUtils;
import com.example.dto.request.AuthUserRequest;
import com.example.dto.response.AuthResponse;


@RestController
@RequestMapping("/api")
public class AuthRestController {
    private final static Logger log = LoggerFactory.getLogger(AuthRestController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthUserRequest request) {
        log.info("AuthRestController.auth() appelé");
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(request.getLogin(), request.getMdp());

        // On demande à Spring Security si le user / password sont OK
        this.authenticationManager.authenticate(auth);

        return new AuthResponse(JwtUtils.generate(auth));
    }
}
