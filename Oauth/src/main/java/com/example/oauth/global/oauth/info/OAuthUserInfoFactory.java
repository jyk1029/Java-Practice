package com.example.oauth.global.oauth.info;

import com.example.oauth.domain.user.domain.type.ProviderType;
import com.example.oauth.global.oauth.exception.InvalidProviderTypeException;
import com.example.oauth.global.oauth.info.impl.GoogleOAuthUserInfo;
import com.example.oauth.global.oauth.info.impl.KakaoOAuthUserInfo;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class OAuthUserInfoFactory {
    public static OAuthUserInfo getOAuth2UserInfo(ProviderType providerType, Map<String, Object> attributes) {

        switch (providerType) {
            case GOOGLE:
                return GoogleOAuthUserInfo.ofGoogle(attributes);
            case KAKAO:
                return KakaoOAuthUserInfo.ofKakao(attributes);
            default:
                throw InvalidProviderTypeException.EXCEPTION;
        }
    }
}
