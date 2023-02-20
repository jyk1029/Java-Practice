package com.example.oauth.global.oauth.info.impl;

import com.example.oauth.global.oauth.info.OAuthUserInfo;

import java.util.Map;

public class FacebookOAuthUserInfo extends OAuthUserInfo{
    public FacebookOAuthUserInfo(Map<String, Object> attributes, String nameAttributeKey, String name, String password, String email) {
        super(attributes, nameAttributeKey, name, password, email);
    }

    public static OAuthUserInfo ofFacebook(Map<String, Object> attributes) {
        return KakaoOAuthUserInfo.builder()
                .name((String) attributes.get("name"))
                .password((String) attributes.get("password"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey("sub")
                .build();
    }
}
