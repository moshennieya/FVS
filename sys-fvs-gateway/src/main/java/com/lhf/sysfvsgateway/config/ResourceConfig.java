package com.lhf.sysfvsgateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.server.SecurityWebFilterChain;

import javax.annotation.Resource;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/7 10:08
 */
@Configuration
@EnableWebFluxSecurity
public class ResourceConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http.oauth2ResourceServer()
                .opaqueToken().introspectionClientCredentials("system", "res1")
                .introspectionUri("http://localhost:8081/oauth/check_token")
                .and()
                .and()
                .authorizeExchange()
                .anyExchange()
                .authenticated()
                .and()
                .cors()
                .and()
                .csrf()
                .disable()
                .formLogin();
        return http.build();
    }

}
