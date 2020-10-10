package com.lhf.sysfvsuserapi.feign;

import com.lhf.sysfvscommon.dto.ClientDetailsDTO;
import com.lhf.sysfvscommon.entity.ClientDetails;
import com.lhf.sysfvsuserapi.feign.fallback.ClientDetailsFallback;
import com.lhf.sysfvsuserapi.feign.fallback.SysPerFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/15 17:01
 */
@FeignClient(value = "sys-user-service", contextId = "clientDetailsFeign")
public interface ClientDetailsFeign {

    /**
     * 添加
     *
     * @return
     */
    @PostMapping("/client/insert")
    boolean insert(@RequestBody ClientDetails params);

    @DeleteMapping("/client/delete")
    boolean delete(@RequestBody String clientId);

    @PutMapping("/client/update")
    boolean update(@RequestBody ClientDetails params);

    @GetMapping("/client/queryById/{clientId}")
    ClientDetailsDTO queryByClientId(@PathVariable String clientId);

}
