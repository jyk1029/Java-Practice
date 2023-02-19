package com.example.oauth.domain.user.service;

import com.example.oauth.domain.user.controller.dto.request.UserSignUpRequest;
import com.example.oauth.domain.user.domain.User;
import com.example.oauth.domain.user.domain.repository.UserRepository;
import com.example.oauth.domain.user.domain.type.ProviderType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {
    private final UserRepository userRepository;
    @Transactional
    public void execute(UserSignUpRequest request) {
        userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .name(request.getName())
                        .providerType(ProviderType.LOCAL)
                        .build());
    }
}
