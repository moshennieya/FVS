package com.lhf.sysfvsuserapi.feign;

import com.lhf.sysfvscommon.dto.SysPerDTO;
import com.lhf.sysfvscommon.entity.SysPer;
import com.lhf.sysfvsuserapi.feign.fallback.SysPerFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/6 15:03
 */
@FeignClient(value = "sys-user-service", contextId = "sysPerFeign", fallbackFactory = SysPerFallback.class)
public interface SysPerFeign {

    /**
     * 添加角色
     *
     * @param params
     * @return
     */
    @PostMapping("per/insert")
    boolean insert(@RequestBody SysPer params);

    /**
     * 条件查询多条信息
     *
     * @param menuName
     * @param menuType
     * @param per
     * @param parentId
     * @return
     */
    @GetMapping("per/any")
    List<SysPerDTO> queryAny(@RequestParam(required = false) String menuName, @RequestParam(required = false) Integer menuType,
                             @RequestParam(required = false) String per, @RequestParam(required = false) Integer parentId);
}
