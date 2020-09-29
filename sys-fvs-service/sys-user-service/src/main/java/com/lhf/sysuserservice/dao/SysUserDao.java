package com.lhf.sysuserservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhf.sysfvscommon.dto.SysUserDTO;
import com.lhf.sysfvscommon.entity.SysUser;

import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/17 16:16
 */
public interface SysUserDao extends BaseMapper<SysUser> {
    /**
     * 查询用户所有信息
     * 包括角色信息权限信息
     *
     * @param userId
     * @return
     */
    List<SysUserDTO> queryAnyByUserId(Long userId);
}
