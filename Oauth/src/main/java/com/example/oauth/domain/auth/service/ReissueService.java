package com.example.oauth.domain.auth.service;

import com.example.oauth.domain.auth.controller.dto.response.TokenResponse;
import com.example.oauth.domain.auth.domain.RefreshToken;
import com.example.oauth.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.oauth.domain.auth.exception.InvalidRefreshTokenException;
import com.example.oauth.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.oauth.global.security.jwt.JwtProperties;
import com.example.oauth.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReissueService {
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;

    @Transactional
    public TokenResponse execute(String refreshToken) {
        String parseToken = jwtTokenProvider.parseToken(refreshToken);

        if(parseToken == null) {
            throw InvalidRefreshTokenException.EXCEPTION;
        }

        RefreshToken redisRefreshToken = refreshTokenRepository.findByToken(jwtTokenProvider.parseToken(refreshToken))
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String newRefreshToken = jwtTokenProvider.generateRefreshToken(redisRefreshToken.getEmail());
        redisRefreshToken.updateToken(newRefreshToken, jwtProperties.getRefreshExp());

        String newAccessToken = jwtTokenProvider.generateAccessToken(redisRefreshToken.getEmail());

        return TokenResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .build();
    }
}
