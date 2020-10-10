package com.lhf.sysfvsuserapi.feign.fallback;

import com.lhf.sysfvsuserapi.feign.ClientDetailsFeign;
import feign.hystrix.FallbackFactory;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/6 17:26
 */
public class ClientDetailsFallback implements FallbackFactory<ClientDetailsFeign> {
    @Override
    public ClientDetailsFeign create(Throwable throwable) {
        return null;
    }
}
