package com.example.oauth.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UserSignInRequest {
    @NotBlank(message = "email은 null, 공백, 띄어쓰기를 할 수 없습니다.")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @NotBlank(message = "password는 null, 공백, 띄어쓰기를 할 수 없습니다.")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!/?@])[a-zA-Z0-9!/" + "?@]{8,20}$",
            message = "password는 소문자, 숫자, 특수문자가 포함되어야 하며 8자 이상 20자 이하여야 합니다.")
    private String password;
}
