package com.example.oauth.global.oauth.info.dto;

import com.example.oauth.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class SessionUser implements Serializable {
    private String name;
    private String password;
    private String email;

    public SessionUser(User user) {
        this.name = user.getName();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }
}
