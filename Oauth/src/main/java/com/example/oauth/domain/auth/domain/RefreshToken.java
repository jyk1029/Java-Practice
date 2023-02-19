package com.example.oauth.domain.auth.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash(value = "RefrshToken", timeToLive = 60 * 60 * 2)
public class RefreshToken {
    @Id
    private String email;

    @Indexed
    private String token;

    @TimeToLive
    private Long timeToLive;

    @Builder
    public RefreshToken(String email, String token, Long timeToLive) {
        this.email = email;
        this.token = token;
        this.timeToLive = timeToLive;
    }
}
