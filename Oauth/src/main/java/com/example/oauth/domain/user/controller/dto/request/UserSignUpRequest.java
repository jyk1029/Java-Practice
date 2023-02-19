package com.example.oauth.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {
    @NotBlank(message = "email은 null, 공백, 띄어쓰기를 할 수 없습니다.")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @NotBlank(message = "name은 null, 공백, 띄어쓰기를 할 수 없습니다.")
    @Size(max = 5)
    private String name;
}
