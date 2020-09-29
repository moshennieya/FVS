package com.lhf.sysuserservice.service.inter;

import com.lhf.sysfvscommon.dto.ClientDetailsDTO;
import com.lhf.sysfvscommon.entity.ClientDetails;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/15 15:05
 */
public interface ClientDetailsService {


    /**
     * 添加
     *
     * @param params
     * @return
     */
    boolean insert(ClientDetails params);

    /**
     * 修改
     *
     * @param params
     * @return
     */
    boolean update(ClientDetails params);

    /**
     * 删除
     *
     * @param clientId
     * @return
     */
    boolean delete(String clientId);

    /**
     * 精确查找,包含资源
     *
     * @param clientId
     * @return
     */
    ClientDetailsDTO queryByClientId(String clientId);


}
