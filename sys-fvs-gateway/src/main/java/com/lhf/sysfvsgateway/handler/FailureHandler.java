package com.lhf.sysfvsgateway.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;
import reactor.core.publisher.Mono;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/14 17:39
 */
public class FailureHandler implements ServerAuthenticationFailureHandler {
    private static final Logger logger = LoggerFactory.getLogger(FailureHandler.class);

    @Override
    public Mono<Void> onAuthenticationFailure(WebFilterExchange exchange, AuthenticationException exception) {
        logger.error("登录失败:::::::::{}", exception.getMessage());
        ServerHttpResponse response = exchange.getExchange().getResponse();
        DataBufferFactory bufferFactory = response.bufferFactory();
        DataBuffer wrap = bufferFactory.wrap("登录失败".getBytes());
        return response.writeWith(Mono.just(wrap));
    }
}
