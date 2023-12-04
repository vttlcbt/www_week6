package com.example.demo.resource;

import com.example.demo.models.User;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.RegisterRequest;
import com.example.demo.response.DataResponse;
import com.example.demo.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationResource {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<DataResponse<User>> register(
            @RequestBody User user) {
        RegisterRequest request = new RegisterRequest(user.getFirstName(), user.getMiddleName(), user.getLastName(), user.getEmail(), user.getPasswordHash());
        return ResponseEntity.ok(authenticationService.register(request));
    }

    ;

    @PostMapping("/login")
    public ResponseEntity<DataResponse<User>> login(
            @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }

    ;
}
