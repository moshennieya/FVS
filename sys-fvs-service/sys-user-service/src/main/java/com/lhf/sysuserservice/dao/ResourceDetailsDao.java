package com.lhf.sysuserservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhf.sysfvscommon.entity.ResourceDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/16 20:12
 */
public interface ResourceDetailsDao extends BaseMapper<ResourceDetails> {


    /**
     * 根据客户端id查询所有资源
     *
     * @param clientId
     * @return
     */
    List<ResourceDetails> queryByClientId(String clientId);

    /**
     * 批量添加
     *
     * @param resources
     * @return
     */
    int insertAny(@Param("list") List<ResourceDetails> resources);
}
