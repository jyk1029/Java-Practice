package com.example.oauth.domain.auth.controller;

import com.example.oauth.domain.auth.controller.dto.response.TokenResponse;
import com.example.oauth.domain.auth.service.ReissueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {
    private final ReissueService reissueService;

    @PatchMapping
    public TokenResponse reissue(@RequestHeader("refresh-token") String refreshToken) {
        return reissueService.execute(refreshToken);
    }
}
