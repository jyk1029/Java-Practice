package com.example.oauth.domain.user.service;

import com.example.oauth.domain.auth.controller.dto.response.TokenResponse;
import com.example.oauth.domain.user.controller.dto.request.UserSignInRequest;
import com.example.oauth.domain.user.domain.User;
import com.example.oauth.domain.user.domain.repository.UserRepository;
import com.example.oauth.domain.user.exception.UserNotFoundException;
import com.example.oauth.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignInService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(UserSignInRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        String accessToken = jwtTokenProvider.generateAccessToken(user.getEmail());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getEmail());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
