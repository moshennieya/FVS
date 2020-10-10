package com.lhf.sysfvsauth.config;

import com.lhf.sysfvsauth.config.jwt.FvsJwt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collections;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/5 9:31
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {


    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private RedisConnectionFactory redisConnectionFactory;

//    @Resource
//    private ClientDetailsService clientDetailsService;

    @Resource
    private DataSource dataSource;

    @Resource(name = "clientDetailsServiceImpl")
    private ClientDetailsService clientDetailsService;

    /**
     * 安全配置
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("permitAll()")
                .tokenKeyAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

    /**
     * 客户端配置
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.withClientDetails(clientDetailsService).build();
//        clients.inMemory()
//                .withClient("system")
//                .resourceIds("sys")
//                .secret(passwordEncoder.encode("123"))
//                .accessTokenValiditySeconds(3000)
//                .authorizedGrantTypes("authorization_code", "refresh_token", "password")
//                .redirectUris("http://localhost:1103/api/test/lhf/hello", "https://oauth.pstmn.io/v1/callback")
//                .scopes("all")
//                .autoApprove(true);
    }

    /**
     * 节点配置
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authorizationCodeServices(authorizationCodeServices())
                .tokenServices(tokenServices())
        ;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(new JwtAccessTokenConverter());
//        return new RedisTokenStore(redisConnectionFactory);
    }

    @Bean
    public JwtAccessTokenConverter tokenConverter() {
        FvsJwt converter = new FvsJwt();
        converter.setSigningKey("fvs");
//        converter.setVerifierKey("lhf");
        return converter;
    }

    @Bean
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setClientDetailsService(clientDetailsService);
        tokenServices.setRefreshTokenValiditySeconds(60 * 30);
        tokenServices.setReuseRefreshToken(true);
        tokenServices.setSupportRefreshToken(true);
        TokenEnhancerChain enhancer = new TokenEnhancerChain();
        enhancer.setTokenEnhancers(Collections.singletonList(tokenConverter()));
        tokenServices.setTokenEnhancer(enhancer);
        return tokenServices;
    }

    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
//        return new InMemoryAuthorizationCodeServices();
        return new JdbcAuthorizationCodeServices(dataSource);
    }
}
