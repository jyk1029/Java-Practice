package com.example.oauth.global.oauth.exception;

import com.example.oauth.global.error.exception.CustomException;
import com.example.oauth.global.error.exception.ErrorCode;

public class InvalidProviderTypeException extends CustomException {
    public static final CustomException EXCEPTION =
            new InvalidProviderTypeException();

    private InvalidProviderTypeException() {
        super(ErrorCode.INVALID_PROVIDER_TYPE);
    }
}
