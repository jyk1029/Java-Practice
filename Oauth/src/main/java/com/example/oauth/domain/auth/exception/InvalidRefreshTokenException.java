package com.example.oauth.domain.auth.exception;

import com.example.oauth.global.error.exception.CustomException;
import com.example.oauth.global.error.exception.ErrorCode;

public class InvalidRefreshTokenException extends CustomException {
    public static final CustomException EXCEPTION =
            new InvalidRefreshTokenException();

    private InvalidRefreshTokenException() {
        super(ErrorCode.INVALID_REFRESH_TOKEN);
    }
}
