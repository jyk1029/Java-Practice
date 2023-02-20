package com.example.oauth.domain.user.service;

import com.example.oauth.domain.user.controller.dto.request.UserSignUpRequest;
import com.example.oauth.domain.user.domain.User;
import com.example.oauth.domain.user.domain.repository.UserRepository;
import com.example.oauth.domain.user.domain.type.ProviderType;
import com.example.oauth.domain.user.domain.type.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(UserSignUpRequest request) {
        userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .name(request.getName())
                        .role(Role.USER)
                        .providerType(ProviderType.LOCAL)
                        .build());
    }
}
