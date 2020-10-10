package com.lhf.sysfvsresources.config.jwt;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/6 10:49
 */
public class FvsJwt extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        Map<String, Object> info = new LinkedHashMap<>();
        info.put("info", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return super.enhance(accessToken, authentication);
    }
}
