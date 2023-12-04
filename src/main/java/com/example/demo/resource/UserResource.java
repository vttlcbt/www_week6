package com.example.demo.resource;

import com.example.demo.models.User;
import com.example.demo.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class UserResource {
    private final UserServices userServices;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {

        return ResponseEntity.ok(userServices.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable String id) {
        return ResponseEntity.ok(userServices.getUserById(Long.parseLong(id)));
    }
}
