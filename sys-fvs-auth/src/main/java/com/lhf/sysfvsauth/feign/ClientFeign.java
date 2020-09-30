package com.lhf.sysfvsauth.feign;

import com.lhf.sysfvscommon.dto.ClientDetailsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/15 16:16
 */
@FeignClient(value = "sys-user-service",contextId = "clientFeign")
public interface ClientFeign {

    /**
     * 查询客户端信息
     *
     * @param clientId
     * @return
     */
    @GetMapping("/client/queryById/{clientId}")
    ClientDetailsDTO queryByClientId(@PathVariable String clientId);


}
