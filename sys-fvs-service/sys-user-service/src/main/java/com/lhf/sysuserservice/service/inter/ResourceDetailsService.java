package com.lhf.sysuserservice.service.inter;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhf.sysfvscommon.dto.ResourceDetailsDTO;
import com.lhf.sysfvscommon.entity.ResourceDetails;

import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/16 20:12
 */
public interface ResourceDetailsService {

    /**
     * 添加
     *
     * @param params
     * @return
     */
    boolean insert(ResourceDetails params);

    /**
     * 删除
     *
     * @param resourceId
     * @return
     */
    boolean delete(String resourceId);


    /**
     * 修改
     *
     * @param params
     * @return
     */
    boolean update(ResourceDetails params);


    /**
     * 根据客户端id查询资源
     *
     * @param clientId
     * @return
     */
    List<ResourceDetailsDTO> queryByClientId(String clientId);
}
