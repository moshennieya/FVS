package com.lhf.sysfvsresources.config;

import com.lhf.sysfvsresources.config.handler.OauthAccessDeniedHandler;
import com.lhf.sysfvsresources.config.handler.OauthAuthenticationEntryPoint;
import com.lhf.sysfvsresources.config.jwt.FvsJwt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/9 20:29
 */
@EnableResourceServer
@Configuration
public class ResourcesConfig extends ResourceServerConfigurerAdapter {

    @Bean
    public JwtAccessTokenConverter tokenConverter() {
        FvsJwt converter = new FvsJwt();
        converter.setSigningKey("fvs");
        return converter;
    }

    @Bean
    public TokenStore tokenStore(JwtAccessTokenConverter tokenConverter) {
        return new JwtTokenStore(tokenConverter);
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("8e9daef0-5494-48da-8f77-22ac923828bf")
                .authenticationEntryPoint(new OauthAuthenticationEntryPoint())
                .accessDeniedHandler(new OauthAccessDeniedHandler())
//                .tokenServices(tokenServices())
                .tokenStore(tokenStore(tokenConverter()))
        ;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//                .antMatchers("/api/auth/oauth/**").permitAll()
                .antMatchers("/test").hasRole("ROOT")
                .anyRequest().authenticated()
                .and()
                .csrf()
                .disable()
                .cors();
    }
}
