package com.yellowai.chatbotplatform.service;

import com.yellowai.chatbotplatform.dto.LoginRequestDto;
import com.yellowai.chatbotplatform.dto.RegisterRequestDto;
import com.yellowai.chatbotplatform.entity.Role;
import com.yellowai.chatbotplatform.entity.User;
import com.yellowai.chatbotplatform.repository.UserRepository;
import com.yellowai.chatbotplatform.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    /* -------------------------------
       LOGIN
       ------------------------------- */
    public Map<String, String> login(LoginRequestDto request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        String token = jwtUtil.generateToken(request.getEmail());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return response;
    }

    /* -------------------------------
       REGISTER  ✅ FIXED
       ------------------------------- */
    public Map<String, String> register(RegisterRequestDto request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // 🔑 FIXED ENUM USAGE
        user.setRole(Role.valueOf(request.getRole().toUpperCase()));

        userRepository.save(user);

        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully");

        return response;
    }
}
