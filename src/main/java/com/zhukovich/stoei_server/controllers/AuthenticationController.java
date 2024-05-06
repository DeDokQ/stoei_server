package com.zhukovich.stoei_server.controllers;

import com.zhukovich.stoei_server.config.JwtService;
import com.zhukovich.stoei_server.models.User;
import com.zhukovich.stoei_server.repositories.UserRepository;
import com.zhukovich.stoei_server.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthService authService;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            System.console().printf("Email %s already exists!\n", request.getEmail());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authenticationResponseResponseEntity(
            @RequestBody AuthRequest request
    ) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.ok(authService.authenticate(request));
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/getName")
    public ResponseEntity<?> getName(
            @RequestBody AuthenticationResponse response
    ) {
        String userEmail = jwtService.extractUsername(response.getToken());
        User user = userRepository.findByEmail(userEmail).orElse(null);

        return ResponseEntity.ok(user.getFullname());
    }

    @PostMapping("/getId")
    public ResponseEntity<?> getId(
            @RequestBody AuthenticationResponse response
    ) {
        String userEmail = jwtService.extractUsername(response.getToken());
        User user = userRepository.findByEmail(userEmail).orElse(null);

        return ResponseEntity.ok(user.getId());
    }

    @PostMapping("/getRole")
    public ResponseEntity<?> getRole(
            @RequestBody AuthenticationResponse response
    ) {
        String userEmail = jwtService.extractUsername(response.getToken());
        User user = userRepository.findByEmail(userEmail).orElse(null);

        return ResponseEntity.ok(user.getRole());
    }


}