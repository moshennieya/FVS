package com.lhf.sysfvsuserapi.controller;

import com.lhf.sysfvscommon.dto.SysUserDTO;
import com.lhf.sysfvscommon.entity.SysUser;
import com.lhf.sysfvscommon.util.Result;
import com.lhf.sysfvsuserapi.feign.SysUserFeign;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/18 9:39
 */
@RestController
@RequestMapping("sys-user")
public class SysUserController {

    @Resource
    private SysUserFeign sysUserFeign;

    /**
     * 添加用户
     *
     * @param params
     * @return
     */
    @PostMapping("insert")
    public Result<Boolean> insert(@RequestBody SysUser params) {
        return Result.success(this.sysUserFeign.insert(params));
    }


    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @DeleteMapping("delete/{userId}")
    public Result<Boolean> delete(@PathVariable Long userId) {
        return Result.success(this.sysUserFeign.delete(userId));
    }

    /**
     * 更新用户
     *
     * @param params
     * @return
     */
    @PutMapping("update")
    public Result<Boolean> update(@RequestBody SysUser params) {
        return Result.success(this.sysUserFeign.update(params));
    }


    /**
     * 查询用户
     *
     * @param userId
     * @return
     */
    @GetMapping("queryAnyByUserId/{userId}")
    public Result<List<SysUserDTO>> queryAnyByUserId(@PathVariable Long userId) {
        return Result.success(this.sysUserFeign.queryAnyByUserId(userId));
    }


    @GetMapping("code")
    public Result<String> code(String code) {
        if (code == null) {
            return Result.failure();
        }
        return Result.success(code);
    }
}
