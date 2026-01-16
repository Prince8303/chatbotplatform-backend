package com.yellowai.chatbotplatform.service;

import com.yellowai.chatbotplatform.dto.LoginRequest;
import com.yellowai.chatbotplatform.dto.RegisterRequest;
import com.yellowai.chatbotplatform.entity.User;
import com.yellowai.chatbotplatform.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 🔹 Constructor (already exists)
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 🔹 REGISTER METHOD (already exists)
    public void register(RegisterRequest request) {

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
    }

    // 🔥 ADD LOGIN METHOD HERE (THIS IS THE ANSWER)
    public void login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
    }
}
