package com.lhf.sysfvsuserapi.feign;

import com.lhf.sysfvscommon.dto.SysUserDTO;
import com.lhf.sysfvscommon.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/18 9:35
 */
@FeignClient(value = "sys-user-service", contextId = "sysUserFeign")
public interface SysUserFeign {

    /**
     * 添加
     *
     * @param params
     * @return
     */
    @PostMapping("/sys-user/insert")
    boolean insert(@RequestBody SysUser params);


    /**
     * 删除
     *
     * @param userId
     * @return
     */
    @DeleteMapping("sys-user/delete/{userId}")
    boolean delete(@PathVariable Long userId);

    /**
     * 修改
     *
     * @param params
     * @return
     */
    @PutMapping("sys-user/update")
    boolean update(@RequestBody SysUser params);

    /**
     * 查询用户详细信息
     * 包括角色权限信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/sys-user/queryAnyByUserId/{userId}")
    List<SysUserDTO> queryAnyByUserId(@PathVariable Long userId);

}
