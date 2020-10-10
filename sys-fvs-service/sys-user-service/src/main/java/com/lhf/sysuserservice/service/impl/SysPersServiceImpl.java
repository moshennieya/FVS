package com.lhf.sysuserservice.service.impl;

import com.lhf.sysfvscommon.dto.SysPerDTO;
import com.lhf.sysfvscommon.entity.SysPer;
import com.lhf.sysuserservice.dao.SysPerDao;
import com.lhf.sysuserservice.service.inter.SysPersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/6 14:47
 */
@Service
public class SysPersServiceImpl implements SysPersService {

    @Resource
    private SysPerDao sysPerDao;

    @Override
    public boolean insert(SysPer params) {
        return sysPerDao.insert(params) > 0;
    }


    @Override
    public List<SysPerDTO> queryAny(SysPer params) {
        return this.sysPerDao.queryAny(params);
    }
}
