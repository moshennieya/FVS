package com.lhf.sysfvsgateway.config;

import com.lhf.sysfvsgateway.handler.FailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/14 16:16
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange(authorizeExchangeSpec -> authorizeExchangeSpec.anyExchange().authenticated())
//                .exceptionHandling(exceptionHandlingSpec -> exceptionHandlingSpec.authenticationEntryPoint(new UnLoginHandler()).accessDeniedHandler(new AccessDeniedHandler()))
//                .exceptionHandling(exceptionHandlingSpec -> exceptionHandlingSpec.accessDeniedHandler(new AccessDeniedHandler()))
//                .formLogin(formLoginSpec -> formLoginSpec.authenticationSuccessHandler(new SuccessHandler()).authenticationFailureHandler(new FailureHandler()))
                .csrf(csrfSpec -> csrfSpec.csrfTokenRepository(CookieServerCsrfTokenRepository.withHttpOnlyFalse()))
                .cors()
                .and()
                .oauth2Login(oauth -> {
                    oauth.authenticationFailureHandler(new FailureHandler())
                    ;
                })
        ;
        return http.build();
    }

}
