package com.example.oauth.domain.user.controller;

import com.example.oauth.domain.auth.controller.dto.response.TokenResponse;
import com.example.oauth.domain.user.controller.dto.request.UserSignInRequest;
import com.example.oauth.domain.user.controller.dto.request.UserSignUpRequest;
import com.example.oauth.domain.user.service.UserSignInService;
import com.example.oauth.domain.user.service.UserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserSignUpService userSignUpService;
    private final UserSignInService userSignInService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void signUp(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.execute(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserSignInRequest request) {
        return userSignInService.execute(request);
    }
}
