package com.lhf.sysuserservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhf.sysfvscommon.dto.ClientDetailsDTO;
import com.lhf.sysfvscommon.entity.ClientDetails;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/15 14:12
 */
public interface ClientDetailsDao extends BaseMapper<ClientDetails> {

    /**
     * 精确查找,包含资源
     *
     * @param clientId
     * @return
     */
    ClientDetailsDTO queryByClientId(String clientId);
}
