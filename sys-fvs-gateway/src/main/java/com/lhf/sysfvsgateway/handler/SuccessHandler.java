package com.lhf.sysfvsgateway.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import reactor.core.publisher.Mono;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/14 17:02
 */
public class SuccessHandler implements ServerAuthenticationSuccessHandler {
    private static final Logger logger = LoggerFactory.getLogger(SuccessHandler.class);

    @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange exchange, Authentication authentication) {

        logger.info("登陆成功");
        ServerHttpResponse response = exchange.getExchange().getResponse();
        DataBufferFactory buffer = response.bufferFactory();
        DataBuffer wrap = buffer.wrap("登陆成功".getBytes());
        return response.writeWith(Mono.just(wrap));
    }
}
