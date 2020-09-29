package com.lhf.sysuserservice.service.inter;

import com.lhf.sysfvscommon.dto.SysUserDTO;
import com.lhf.sysfvscommon.entity.SysUser;

import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/18 8:46
 */
public interface SysUserService {

    /**
     * 添加
     *
     * @param params
     * @return
     */
    boolean insert(SysUser params);


    /**
     * 删除
     *
     * @param userId
     * @return
     */
    boolean delete(Long userId);

    /**
     * 修改
     *
     * @param params
     * @return
     */
    boolean update(SysUser params);

    /**
     * 查询用户详细信息
     * 包括角色权限信息
     *
     * @param userId
     * @return
     */
    List<SysUserDTO> queryAnyByUserId(Long userId);
}
