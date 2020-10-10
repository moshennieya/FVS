package com.lhf.sysuserservice.service.inter;

import com.lhf.sysfvscommon.dto.SysPerDTO;
import com.lhf.sysfvscommon.entity.SysPer;
import com.lhf.sysfvscommon.entity.SysUser;

import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/6 14:46
 */
public interface SysPersService {

    /**
     * 添加角色
     *
     * @param params
     * @return
     */
    boolean insert(SysPer params);


    /**
     * 条件查询多条信息
     *
     * @param params
     * @return
     */
    List<SysPerDTO> queryAny(SysPer params);
}
