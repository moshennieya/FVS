package com.lhf.sysfvsgateway.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/14 16:58
 */
public class AccessDeniedHandler implements ServerAccessDeniedHandler {

    private static final Logger logger = LoggerFactory.getLogger(AccessDeniedHandler.class);

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, AccessDeniedException denied) {

        logger.error("无权访问:::::::::{}", denied.getMessage());

        ServerHttpResponse response = exchange.getResponse();
        DataBufferFactory buffer = response.bufferFactory();
        DataBuffer wrap = buffer.wrap("无权访问".getBytes());
        Mono<Void> mono = response.writeWith(Mono.just(wrap));
        return mono;
    }
}
