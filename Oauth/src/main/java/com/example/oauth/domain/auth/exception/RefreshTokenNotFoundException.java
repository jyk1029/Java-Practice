package com.example.oauth.domain.auth.exception;

import com.example.oauth.global.error.exception.CustomException;
import com.example.oauth.global.error.exception.ErrorCode;

public class RefreshTokenNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new RefreshTokenNotFoundException();

    private RefreshTokenNotFoundException() {
        super(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }
}
