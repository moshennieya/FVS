package com.lhf.sysfvsauth.feign;

import com.lhf.sysfvscommon.dto.SysUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/30 10:17
 */

@FeignClient(value = "sys-user-service", contextId = "userFeign")
public interface UserFeign {

    /**
     * 通过用户名获取用户信息
     * 登录
     *
     * @param username
     * @return
     */
    @GetMapping("sys-user/queryAnyByUsername/{username}")
    SysUserDTO queryOneByUsername(@PathVariable String username);

}
