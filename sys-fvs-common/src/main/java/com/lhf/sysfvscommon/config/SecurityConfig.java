package com.lhf.sysfvscommon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/15 15:59
 */
@Configuration("securityConfigCommon")
public class SecurityConfig {

    @Bean("passwordEncoderCommon")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
