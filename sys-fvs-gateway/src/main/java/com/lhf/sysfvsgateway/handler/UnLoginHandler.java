package com.lhf.sysfvsgateway.handler;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/14 16:45
 */
public class UnLoginHandler implements ServerAuthenticationEntryPoint {
    private static final Logger logger = LoggerFactory.getLogger(UnLoginHandler.class);

    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException e) {
        logger.error("未登录:::::{}", e.getMessage());
        ServerHttpResponse response = exchange.getResponse();
        String str = JSONUtil.toJsonStr("未登录");
        DataBufferFactory buffer = response.bufferFactory();
        DataBuffer wrap = buffer.wrap(str.getBytes());
        Mono<Void> mono = response.writeWith(Mono.just(wrap));
        return mono;
    }
}
