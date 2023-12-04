package com.example.demo.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.RegisterRequest;
import com.example.demo.response.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;

    public DataResponse<User> register(RegisterRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setMiddleName(request.getMiddleName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPasswordHash(request.getPassword());
        user.setRegisteredAt(java.time.Instant.now());
        try {
            String hash = BCrypt.withDefaults().hashToString(12, request.getPassword().toCharArray());
            user.setPasswordHash(hash);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        var savedUser = userRepository.save(user);



        return DataResponse.<User>builder().data(savedUser).message("Register successfully").status(200).build();

    }

    public DataResponse<User> login(LoginRequest request) {

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();

        return DataResponse.<User>builder().data(user).message("Login successfully").status(200).build();
    }


}
