package com.lhf.sysuserservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhf.sysfvscommon.dto.SysPerDTO;
import com.lhf.sysfvscommon.entity.SysPer;

import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/6 14:42
 */
public interface SysPerDao extends BaseMapper<SysPer> {


    /**
     * 条件查询多条信息
     *
     * @param params
     * @return
     */
    List<SysPerDTO> queryAny(SysPer params);

}
