package com.lhf.sysuserservice.service.impl;

import com.lhf.sysfvscommon.dto.SysUserDTO;
import com.lhf.sysfvscommon.entity.SysUser;
import com.lhf.sysuserservice.dao.SysUserDao;
import com.lhf.sysuserservice.service.inter.SysUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/18 9:09
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean insert(SysUser params) {
        params.setPassword(passwordEncoder.encode(params.getPassword()));
        return this.sysUserDao.insert(params) > 0;
    }

    @Override
    public boolean delete(Long userId) {
        return this.sysUserDao.deleteById(userId) > 0;
    }

    @Override
    public boolean update(SysUser params) {
        Assert.isNull(params.getUserId(), "用户id不能为空");
        return this.sysUserDao.updateById(params) > 0;
    }

    @Override
    public SysUserDTO  queryAnyByUserId(Long userId) {
        return this.sysUserDao.queryAnyByUserIdOrUsername(userId, null);
    }

    @Override
    public SysUserDTO queryByUsername(String username) {
        return this.sysUserDao.queryAnyByUserIdOrUsername(null, username);
    }
}
