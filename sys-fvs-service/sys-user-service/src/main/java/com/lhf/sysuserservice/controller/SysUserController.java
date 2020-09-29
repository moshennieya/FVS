package com.lhf.sysuserservice.controller;

import com.lhf.sysfvscommon.dto.SysUserDTO;
import com.lhf.sysfvscommon.entity.SysUser;
import com.lhf.sysuserservice.service.inter.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/18 9:28
 */
@RestController
@RequestMapping("sys-user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 添加用户
     *
     * @param params
     * @return
     */
    @PostMapping("insert")
    public boolean insert(@RequestBody SysUser params) {
        return this.sysUserService.insert(params);
    }


    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @DeleteMapping("delete/{userId}")
    public boolean delete(@PathVariable Long userId) {
        return this.sysUserService.delete(userId);
    }

    /**
     * 更新用户
     *
     * @param params
     * @return
     */
    @PutMapping("update")
    public boolean update(@RequestBody SysUser params) {
        return this.sysUserService.update(params);
    }


    /**
     * 查询用户
     * @param userId
     * @return
     */
    @GetMapping("queryAnyByUserId/{userId}")
    public List<SysUserDTO> queryAnyByUserId(@PathVariable Long userId) {
        return this.sysUserService.queryAnyByUserId(userId);
    }
}
